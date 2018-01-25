package com.example.jmcaldera.daggertest.data.executor;

import com.example.jmcaldera.daggertest.domain.executor.ThreadExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by jmcaldera on 25-01-18.
 */

@Singleton
public class UseCaseThreadPoolExecutor implements ThreadExecutor {



    private static final int POOL_SIZE = 3;
    private static final int MAX_POOL_SIZE = 5;

    // Sets the amount of time an idle thread waits before terminating
    private static final int TIMEOUT = 10;

    // Sets the Time Unit to seconds
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

    private ThreadPoolExecutor mThreadPoolExecutor;

    private final BlockingQueue<Runnable> mWorkQueue;

    @Inject
    public UseCaseThreadPoolExecutor() {
        this.mWorkQueue = new ArrayBlockingQueue<Runnable>(POOL_SIZE);
        this.mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIMEOUT,
                KEEP_ALIVE_TIME_UNIT, this.mWorkQueue);
    }

    @Override
    public void execute(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }
}
