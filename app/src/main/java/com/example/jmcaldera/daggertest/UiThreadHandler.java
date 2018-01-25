package com.example.jmcaldera.daggertest;

import android.os.Handler;
import android.os.Looper;

import com.example.jmcaldera.daggertest.domain.executor.PostExecutionThread;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by jmcaldera on 25-01-18.
 * MainThread (UI Thread) implementation based on a Handler instantiated with the main
 * application Looper.
 */
@Singleton
public class UiThreadHandler implements PostExecutionThread {

    private final Handler mHandler;

    @Inject
    public UiThreadHandler() {
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * Causes the Runnable r to be added to the message queue.
     * The runnable will be run on the main thread.
     *
     * @param runnable {@link Runnable} to be executed.
     */
    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
