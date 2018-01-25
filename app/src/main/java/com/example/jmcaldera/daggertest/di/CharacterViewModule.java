package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.characters.CharactersContract;
import com.example.jmcaldera.daggertest.characters.CharactersPresenter;

import dagger.Binds;
import dagger.Module;

/**
 * Created by jmcaldera on 25-01-18.
 */

@Module
public abstract class CharacterViewModule {

    @Binds
    abstract CharactersContract.Presenter provideCharactersPresenter(CharactersPresenter charactersPresenter);
}
