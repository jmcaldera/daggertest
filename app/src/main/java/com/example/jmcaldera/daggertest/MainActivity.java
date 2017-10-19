package com.example.jmcaldera.daggertest;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmcaldera.daggertest.domain.repository.Repository;
import com.example.jmcaldera.daggertest.data.CharactersRepository;
import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = MainActivity.class.getSimpleName();

    //TODO: Cambiar el api por repository en mvp
    @Inject
    CharactersRepository mCharactersRepository;
    private List<Character> charactersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeDagger();
//        MarioBros marioBros = marioApi.getMarioBros();
//        renderMarioBros(marioBros);
    }

    @Override
    protected void onResume() {
        super.onResume();
        charactersList = new ArrayList<>();
        mCharactersRepository.getCharacters(new Repository.LoadCharactersCallback() {
            @Override
            public void onSuccess(List<Character> characters) {
                charactersList.addAll(characters);
                Log.d(DEBUG_TAG, "Success!");
                renderCharacters();
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "Error al cargar", Toast.LENGTH_SHORT).show();
                Log.d(DEBUG_TAG, "Error al cargar");
            }
        });
    }

    private void renderCharacters() {
        for (Character character : charactersList) {
            renderName(character.getName());
            renderPhoto(character.getPhoto());
        }
    }

    private void renderMarioBros(MarioBros marioBros) {
        renderName(marioBros.getName());
        renderPhoto(marioBros.getPhoto());
    }

    private void renderPhoto(int photo) {
        ImageView image = (ImageView) findViewById(R.id.image_mario);
        image.setImageDrawable(ContextCompat.getDrawable(this, photo));
    }

    private void renderName(int name) {
        TextView label = (TextView) findViewById(R.id.label_mario);
        label.setText(getString(name));
        Log.d(DEBUG_TAG, getString(name));
    }

    private void renderName(String name) {
        TextView label = (TextView) findViewById(R.id.label_mario);
        label.setText(name);
        Log.d(DEBUG_TAG, name);
    }

    private void initializeDagger() {
        MarioApplication application = (MarioApplication) getApplication();
        application.getCharactersComponent().inject(this);
    }
}
