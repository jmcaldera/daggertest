package com.example.jmcaldera.daggertest;

import android.app.Application;

import com.example.jmcaldera.daggertest.di.CharactersComponent;
import com.example.jmcaldera.daggertest.di.CharactersModule;
import com.example.jmcaldera.daggertest.di.DaggerCharactersComponent;

/**
 * Created by jmcaldera on 03/10/2017.
 */

public class MarioApplication extends Application {

    private CharactersComponent charactersComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        // TODO: Crear el charactercomponent
        charactersComponent = DaggerCharactersComponent.builder()
                .charactersModule(new CharactersModule())
                .build();
    }

    public CharactersComponent getCharactersComponent() {
        return charactersComponent;
    }
}
