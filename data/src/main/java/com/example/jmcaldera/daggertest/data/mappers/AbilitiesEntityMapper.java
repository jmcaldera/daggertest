package com.example.jmcaldera.daggertest.data.mappers;

import com.example.jmcaldera.daggertest.data.model.AbilitiesEntity;
import com.example.jmcaldera.daggertest.domain.mappers.Mapper;
import com.example.jmcaldera.daggertest.domain.model.Abilities;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jmcaldera on 06/10/2017.
 * Mapper class to map a {@link AbilitiesEntity} (data layer) to {@link Abilities} in the
 * domain layer
 */

public class AbilitiesEntityMapper implements Mapper<AbilitiesEntity, Abilities> {

    @Inject
    public AbilitiesEntityMapper() {
    }

    @Override
    public Abilities map(AbilitiesEntity model) {
        if (model == null) {
            return null;
        }

        return Abilities.Builder.create()
                .setAccelerate(model.getAccelerate())
                .setBrake(model.getBrake())
                .setDrift(model.getDrift())
                .setLookBehind(model.getLookBehind())
                .setReverse(model.getReverse())
                .setSteer(model.getSteer())
                .build();
    }
}
