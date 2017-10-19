package com.example.jmcaldera.daggertest.data.mappers;

import com.example.jmcaldera.daggertest.data.model.CharacterEntity;
import com.example.jmcaldera.daggertest.domain.mappers.ListMapper;
import com.example.jmcaldera.daggertest.domain.model.Character;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jmcaldera on 06/10/2017.
 * Mapper class to map a List of {@link CharacterEntity} (data layer) to a List of {@link Character}
 * in the domain layer
 */

@Singleton
public class CharactersEntityListMapper extends ListMapper<CharacterEntity, Character> {

    @Inject
    public CharactersEntityListMapper(CharacterEntityMapper mapper) {
        super(mapper);
    }
}
