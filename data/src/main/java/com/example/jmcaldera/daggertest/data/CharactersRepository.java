package com.example.jmcaldera.daggertest.data;

import android.support.annotation.NonNull;

import com.example.jmcaldera.daggertest.data.mappers.CharactersEntityListMapper;
import com.example.jmcaldera.daggertest.data.model.CharacterEntity;
import com.example.jmcaldera.daggertest.data.source.DataSource;
import com.example.jmcaldera.daggertest.domain.model.Character;
import com.example.jmcaldera.daggertest.domain.repository.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jmcaldera on 03/10/2017.
 */

@Singleton
public class CharactersRepository implements Repository {

    private DataSource mLocalDataSource;
    private CharactersEntityListMapper mListMapper;

    @Inject
    public CharactersRepository(@NonNull DataSource localDataSource, @NonNull CharactersEntityListMapper listMapper) {
        this.mLocalDataSource = localDataSource;
        this.mListMapper = listMapper;
    }

    @Override
    public void getCharacters(final LoadCharactersCallback callback) {
        mLocalDataSource.getCharactersEntity(new DataSource.LoadCharactersCallback() {
            @Override
            public void onSuccess(List<CharacterEntity> charactersList) {
                List<Character> characters = mListMapper.map(charactersList);
                callback.onSuccess(characters);
            }

            @Override
            public void onError(Throwable error) {
                callback.onError(error);
            }
        });
    }
}
