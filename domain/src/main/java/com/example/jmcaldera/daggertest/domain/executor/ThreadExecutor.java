package com.example.jmcaldera.daggertest.domain.executor;

/**
 * Created by jmcaldera on 24-01-18.
 */

import com.example.jmcaldera.daggertest.domain.usecase.UseCase;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the {@link UseCase} out of the UI thread.
 *  *
 * Use this class to execute an {@link UseCase}.
 *
*/
public interface ThreadExecutor {
    /**
     * Executes a {@link Runnable}.
     *
     * @param runnable The class that implements {@link Runnable} interface.
     */
    void execute(final Runnable runnable);
}
