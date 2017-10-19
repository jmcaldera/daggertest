package com.example.jmcaldera.daggertest;

/**
 * Created by jmcaldera on 03/10/2017.
 */

public class MarioBros {

    private int name;
    private int photo;

    public MarioBros() {
        this.name = R.string.mario_bros_name;
        this.photo = R.drawable.mario_bros;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
