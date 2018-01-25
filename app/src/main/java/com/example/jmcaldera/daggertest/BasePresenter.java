package com.example.jmcaldera.daggertest;

/**
 * Created by jmcaldera on 25-01-18.
 */

public interface BasePresenter<T> {

    void setView(T view);

    void dropView();
}
