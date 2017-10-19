package com.example.jmcaldera.daggertest.data.source;

import com.example.jmcaldera.daggertest.data.model.CharacterEntity;

import java.util.List;

/**
 * Created by jmcaldera on 06/10/2017.
 */

public interface DataSource {

    interface LoadCharactersCallback {

        void onSuccess(List<CharacterEntity> charactersList);

        void onError();
    }

    void getCharactersEntity(LoadCharactersCallback callback);
}
