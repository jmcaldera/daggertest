package com.example.jmcaldera.daggertest.domain.mappers;

/**
 * Created by jmcaldera on 06/10/2017.
 */

public interface Mapper<M, P> {

    P map(M model);
}
