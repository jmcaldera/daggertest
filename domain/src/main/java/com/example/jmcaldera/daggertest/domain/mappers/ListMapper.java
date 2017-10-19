package com.example.jmcaldera.daggertest.domain.mappers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jmcaldera on 06/10/2017.
 */

public class ListMapper<M, P> implements Mapper<List<M>, List<P>> {

    private Mapper<M, P> mapper;

    public ListMapper(Mapper<M, P> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<P> map(List<M> models) {
        ArrayList<P> elements = new ArrayList<>();
        if (models != null && models.size() > 0) {
            for (M model : models) {
                elements.add(mapper.map(model));
            }
        }
        return elements;
    }
}
