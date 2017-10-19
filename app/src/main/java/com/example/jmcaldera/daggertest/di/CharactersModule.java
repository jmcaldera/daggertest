package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.data.source.local.LocalDataSource;
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
    Repository proviceLocalDataSource() {
        return new LocalDataSource();
    }
}
