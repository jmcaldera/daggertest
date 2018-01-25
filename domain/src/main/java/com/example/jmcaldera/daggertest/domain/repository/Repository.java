package com.example.jmcaldera.daggertest.domain.repository;

import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.List;

/**
 * Created by jmcaldera on 03/10/2017.
 */

public interface Repository {

    interface LoadCharactersCallback {
        void onSuccess(List<Character> characters);

        void onError(Throwable error);
    }

    void getCharacters(LoadCharactersCallback callback);

}
