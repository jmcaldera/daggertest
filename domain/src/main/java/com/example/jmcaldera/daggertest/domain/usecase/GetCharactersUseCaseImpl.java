package com.example.jmcaldera.daggertest.domain.usecase;

import com.example.jmcaldera.daggertest.domain.executor.PostExecutionThread;
import com.example.jmcaldera.daggertest.domain.executor.ThreadExecutor;
import com.example.jmcaldera.daggertest.domain.model.Character;
import com.example.jmcaldera.daggertest.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jmcaldera on 05/10/2017.
 */

public class GetCharactersUseCaseImpl implements GetCharactersUseCase {

    //TODO: refactor repository para que existe la interface de Repository en domain y se implemente en data
    // TODO: crear interface Repository en data para implementar en local y cloud, como el ejemplo de erik
    // TODO: así, domain sabe de la interfaz repository y se le inyecta al use case la implementacion de Repository que conoce los repository
    private Repository mRepository;
    private ThreadExecutor mThreadExecutor;
    private PostExecutionThread mPostExecutionThread;

    private Callback mCallback;

    @Inject
    public GetCharactersUseCaseImpl(Repository repository, ThreadExecutor threadExecutor,
                                    PostExecutionThread postExecutionThread) {
        this.mRepository = repository;
        this.mThreadExecutor = threadExecutor;
        this.mPostExecutionThread = postExecutionThread;
    }

    @Override
    public void run() {
        mRepository.getCharacters(new Repository.LoadCharactersCallback() {
            @Override
            public void onSuccess(List<Character> characters) {
                notifySuccess(characters);
            }

            @Override
            public void onError(Throwable error) {
                notifyError(error);
            }
        });
    }

    @Override
    public void execute(final Callback callback) {

        if (callback == null) {
            throw new IllegalArgumentException("Use case callback can't be null!");
        }

        this.mCallback = callback;
        this.mThreadExecutor.execute(this);

    }

    private void notifySuccess(final List<Character> characters) {
        this.mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onCharactersLoaded(characters);
            }
        });
    }

    private void notifyError(final Throwable error) {
        this.mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onError(error);
            }
        });
    }

}
