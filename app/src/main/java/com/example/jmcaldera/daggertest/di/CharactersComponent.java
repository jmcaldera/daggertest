package com.example.jmcaldera.daggertest.di;

import com.example.jmcaldera.daggertest.MainActivity;
import com.example.jmcaldera.daggertest.data.CharactersRepository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by jmcaldera on 03/10/2017.
 */

@Singleton
@Component(modules = {CharactersModule.class})
public interface CharactersComponent {

    void inject(MainActivity mainActivity);

    CharactersRepository getRepository();

}
