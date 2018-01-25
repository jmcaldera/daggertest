package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.domain.usecase.GetCharactersUseCase;
import com.example.jmcaldera.daggertest.domain.usecase.GetCharactersUseCaseImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jmcaldera on 25-01-18.
 */

@Module
public class UseCaseModule {

    @Provides
    GetCharactersUseCase provideGetCharactersUseCase(GetCharactersUseCaseImpl getCharactersUseCase) {
        return getCharactersUseCase;
    }
}
