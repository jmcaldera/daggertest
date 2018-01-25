package com.example.jmcaldera.daggertest.characters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jmcaldera.daggertest.MarioApplication;
import com.example.jmcaldera.daggertest.R;
import com.example.jmcaldera.daggertest.domain.model.Character;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CharactersActivity extends AppCompatActivity implements CharactersContract.View {

    private static final String DEBUG_TAG = CharactersActivity.class.getSimpleName();

    //TODO: Cambiar el api por repository en mvp

    @Inject
    CharactersContract.Presenter mPresenter;

    private CharactersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_characters);
        initializeDagger();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));

        mAdapter = new CharactersAdapter(new ArrayList<Character>(0));
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.dropView();
    }

    private void initializeDagger() {
        MarioApplication application = (MarioApplication) getApplication();
        application.getCharactersComponent().inject(this);
    }

    @Override
    public void showCharacters(List<Character> characters) {
        Log.d(DEBUG_TAG, "Success!");
        mAdapter.replaceData(characters);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean isActive() {
        return true;
    }

    public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersViewHolder> {

        List<Character> mCharacters;

        public CharactersAdapter(List<Character> characters) {
            replaceData(characters);
        }

        private void replaceData(List<Character> characters) {
            setList(characters);
            notifyDataSetChanged();
        }

        private void setList(List<Character> characters) {
            this.mCharacters = characters;
        }

        @Override
        public CharactersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.character_item, parent, false);

            return new CharactersViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CharactersViewHolder holder, int position) {
            Character character = mCharacters.get(position);
            holder.mCharacterName.setText(character.getName());
            holder.mCharacterPhoto.setImageResource(character.getPhoto());
        }

        @Override
        public int getItemCount() {
            return mCharacters.size();
        }

        class CharactersViewHolder extends RecyclerView.ViewHolder {

            ImageView mCharacterPhoto;
            TextView mCharacterName;

            CharactersViewHolder(View itemView) {
                super(itemView);
                mCharacterPhoto = itemView.findViewById(R.id.character_photo);
                mCharacterName = itemView.findViewById(R.id.character_name);
            }
        }
    }
}
