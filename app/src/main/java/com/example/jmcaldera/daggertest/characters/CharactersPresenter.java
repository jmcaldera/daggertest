package com.example.jmcaldera.daggertest.characters;

import com.example.jmcaldera.daggertest.domain.model.Character;
import com.example.jmcaldera.daggertest.domain.usecase.GetCharactersUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jmcaldera on 25-01-18.
 */

public class CharactersPresenter implements CharactersContract.Presenter {


    private GetCharactersUseCase mGetCharactersUseCase;
    // Add Mapper from domain to presentation

    private CharactersContract.View mView;

    @Inject
    public CharactersPresenter(GetCharactersUseCase getCharactersUseCase) {
        this.mGetCharactersUseCase = getCharactersUseCase;
    }

    @Override
    public void setView(CharactersContract.View view) {
        this.mView = view;
        loadCharacters();
    }

    @Override
    public void dropView() {
        this.mView = null;
    }

    @Override
    public void loadCharacters() {
        mGetCharactersUseCase.execute(new GetCharactersUseCase.Callback() {
            @Override
            public void onCharactersLoaded(List<Character> characters) {
                mView.showCharacters(characters);
            }

            @Override
            public void onError(Throwable error) {
                mView.showError(error.getMessage());
            }
        });
    }
}
