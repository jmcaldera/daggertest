package com.example.jmcaldera.daggertest.domain.usecase;

import com.example.jmcaldera.daggertest.domain.repository.Repository;

import javax.inject.Inject;

/**
 * Created by jmcaldera on 05/10/2017.
 */

public class GetCharactersUseCaseImpl implements GetCharactersUseCase {

    //TODO: refactor repository para que existe la interface de Repository en domain y se implemente en data
    // TODO: crear interface Repository en data para implementar en local y cloud, como el ejemplo de erik
    // TODO: así, domain sabe de la interfaz repository y se le inyecta al use case la implementacion de Repository que conoce los repository
    private Repository repository;

    // TODO: Agregar dagger a Domain e injectar aqui
    @Inject
    public GetCharactersUseCaseImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void run() {

    }

    @Override
    public void execute(Callback callback) {

    }
}
