package com.example.jmcaldera.daggertest.characters;

import com.example.jmcaldera.daggertest.BasePresenter;
import com.example.jmcaldera.daggertest.BaseView;
import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.List;

/**
 * Created by jmcaldera on 25-01-18.
 */

public interface CharactersContract {

    interface View extends BaseView<Presenter> {

        void showCharacters(List<Character> characters);

        void showError(String error);

        boolean isActive();
    }

    interface Presenter extends BasePresenter<View> {

        void loadCharacters();
    }
}
