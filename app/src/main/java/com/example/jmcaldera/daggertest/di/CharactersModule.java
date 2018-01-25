package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.UiThreadHandler;
import com.example.jmcaldera.daggertest.data.CharactersRepository;
import com.example.jmcaldera.daggertest.data.executor.UseCaseThreadPoolExecutor;
import com.example.jmcaldera.daggertest.data.mappers.CharacterEntityMapper;
import com.example.jmcaldera.daggertest.data.mappers.CharactersEntityListMapper;
import com.example.jmcaldera.daggertest.data.source.DataSource;
import com.example.jmcaldera.daggertest.data.source.local.LocalDataSource;
import com.example.jmcaldera.daggertest.domain.executor.PostExecutionThread;
import com.example.jmcaldera.daggertest.domain.executor.ThreadExecutor;
import com.example.jmcaldera.daggertest.domain.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jmcaldera on 03/10/2017.
 */

@Module
public class CharactersModule {

    @Singleton
    @Provides
    DataSource provideLocalDataSource(LocalDataSource localDataSource) {
        return localDataSource;
    }

    @Singleton
    @Provides
    Repository provideCharactersRepository(CharactersRepository repository) {
        return repository;
    }

    @Singleton
    @Provides
    ThreadExecutor provideThreadExecutor(UseCaseThreadPoolExecutor executor) {
        return executor;
    }

    @Singleton
    @Provides
    PostExecutionThread providePostExecutionThread(UiThreadHandler uiThreadHandler) {
        return uiThreadHandler;
    }
}
