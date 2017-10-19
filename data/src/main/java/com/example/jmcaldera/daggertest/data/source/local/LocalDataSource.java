package com.example.jmcaldera.daggertest.data.source.local;

import com.example.jmcaldera.daggertest.data.model.AbilitiesEntity;
import com.example.jmcaldera.daggertest.data.model.CharacterEntity;
import com.example.jmcaldera.daggertest.data.source.DataSource;
import com.example.jmcaldera.daggertest.data.R;
import com.example.jmcaldera.daggertest.domain.model.Abilities;
import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

/**
 * Created by jmcaldera on 03/10/2017.
 */

@Singleton
public class LocalDataSource implements DataSource {

    private List<CharacterEntity> characters;

    public LocalDataSource() {
        this.characters = new ArrayList<>();
    }

    @Override
    public void getCharactersEntity(LoadCharactersCallback callback) {
        fillList();
        if (characters.isEmpty()) {
            callback.onError();
        } else {
            callback.onSuccess(characters);
        }
    }

    private void fillList() {
        addCharacter(getMarioBros());
    }

    private void addCharacter(CharacterEntity character) {
        this.characters.add(character);
    }

    private CharacterEntity getMarioBros() {
        final int accelerate = 100;
        final int steer = 95;
        final int brake = 83;
        final int reverse = 87;
        final int lookBehind = 100;
        final int drift = 100;

        final String id = "1";
        final String name = "Mario Bros";
        final int photo = R.drawable.ic_mario;
        final String description =
                "The plumber star of the series. His kart is average across the board. When Mario is controlled by the computer, his main item used is the Star.";
        final AbilitiesEntity abilities = AbilitiesEntity.Builder.create()
                .setAccelerate(accelerate)
                .setBrake(steer)
                .setDrift(brake)
                .setLookBehind(reverse)
                .setReverse(lookBehind)
                .setSteer(drift)
                .build();

        return CharacterEntity.Builder.create()
                .setId(id)
                .setName(name)
                .setPhoto(photo)
                .setDescription(description)
                .setAbilities(abilities)
                .build();
    }
}
