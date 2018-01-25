package com.example.jmcaldera.daggertest.data.mappers;

import com.example.jmcaldera.daggertest.data.model.CharacterEntity;
import com.example.jmcaldera.daggertest.domain.mappers.Mapper;
import com.example.jmcaldera.daggertest.domain.model.Character;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jmcaldera on 06/10/2017.
 * Mapper class to map a {@link CharacterEntity} (data layer) to {@link Character} in the
 * domain layer
 */

public class CharacterEntityMapper implements Mapper<CharacterEntity, Character> {

//    private static final AbilitiesEntityMapper ABILITIES_MAPPER = new AbilitiesEntityMapper();
    private  AbilitiesEntityMapper mAbilitiesMapper;

    @Inject
    public CharacterEntityMapper(AbilitiesEntityMapper abilitiesEntityMapper) {
        this.mAbilitiesMapper = abilitiesEntityMapper;
    }

    @Override
    public Character map(CharacterEntity model) {
        if (model == null) {
            return null;
        }

        return Character.Builder.create()
                .setId(model.getId())
                .setName(model.getName())
                .setPhoto(model.getPhoto())
                .setDescription(model.getDescription())
                .setAbilities(mAbilitiesMapper.map(model.getAbilities()))
                .build();

    }
}
