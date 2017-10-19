package com.example.jmcaldera.daggertest.domain.usecase;

/**
 * Created by jmcaldera on 05/10/2017.
 */

public interface GetCharactersUseCase extends UseCase {

    interface Callback {

        void onSuccess();

        void onError();
    }

    void execute(Callback callback);
}
