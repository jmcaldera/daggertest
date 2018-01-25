package com.example.jmcaldera.daggertest.domain.usecase;

import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.List;

/**
 * Created by jmcaldera on 05/10/2017.
 */

public interface GetCharactersUseCase extends UseCase {

    interface Callback {

        void onCharactersLoaded(List<Character> characters);

        void onError(Throwable error);
    }

    void execute(Callback callback);
}
