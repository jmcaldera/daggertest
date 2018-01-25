package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.characters.CharactersActivity;
import com.example.jmcaldera.daggertest.data.CharactersRepository;
import com.example.jmcaldera.daggertest.domain.executor.PostExecutionThread;
import com.example.jmcaldera.daggertest.domain.executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jmcaldera on 03/10/2017.
 */

@Singleton
@Component(modules = {CharactersModule.class, UseCaseModule.class, CharacterViewModule.class})
public interface CharactersComponent {

    void inject(CharactersActivity charactersActivity);

    CharactersRepository getRepository();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();

}
