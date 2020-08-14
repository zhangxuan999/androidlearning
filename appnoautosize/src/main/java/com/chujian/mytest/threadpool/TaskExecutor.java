package com.chujian.mytest.threadpool;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskExecutor {
    private static final String TAG = TaskExecutor.class.getSimpleName();

    private static final int NORMAL_CORE_POOL_SIZE = Math.max(Runtime.getRuntime().availableProcessors(), 5);
    private static final int NORMAL_MAX_POOL_SIZE = NORMAL_CORE_POOL_SIZE * 2 + 1;
    private static final long NORMAL_KEEP_ALIVE_TIME = 5L;

    private final Object mLock = new Object();
    private static volatile TaskExecutor sInstance;
    private volatile ThreadPoolExecutor mThreadPoolExecutor = null;
    private volatile ScheduledThreadPoolExecutor mScheduledService = null;

    private volatile Handler mMainHandler;

    public static TaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (TaskExecutor.class) {
            if (sInstance == null) {
                sInstance = new TaskExecutor();
            }
        }
        return sInstance;
    }

    public void executeOnScheduleTask(Runnable runnable, long delay) {
        getScheduledService().schedule(runnable, delay, TimeUnit.MILLISECONDS);
    }

    public ScheduledFuture<?> executeOnScheduleTask(Runnable runnable, long delay, TimeUnit unit) {
        return getScheduledService().schedule(runnable, delay, unit);
    }

    public void executeOnThread(Runnable runnable) {
        getThreadService().submit(runnable);
    }

    public void postToMainThread(Runnable runnable) {
        if (mMainHandler == null) {
            synchronized (mLock) {
                if (mMainHandler == null) {
                    mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        //noinspection ConstantConditions
        mMainHandler.post(runnable);
    }

    public void delayPostToMainThread(Runnable runnable, long delayMillis) {
        if (mMainHandler == null) {
            synchronized (mLock) {
                if (mMainHandler == null) {
                    mMainHandler = new Handler(Looper.getMainLooper());
                }
            }
        }
        //noinspection ConstantConditions
        mMainHandler.postDelayed(runnable, delayMillis);
    }

    public boolean isMainThread() {
        boolean isMainThread = Looper.getMainLooper().getThread() == Thread.currentThread();
        Log.d(TAG, "TaskExecutor isMainThread:" + isMainThread);
        return isMainThread;
    }

    private boolean isScheduledServiceEnable() {
        return !(mScheduledService == null
                || mScheduledService.isShutdown() || mScheduledService.isTerminated());
    }

    private ScheduledExecutorService getScheduledService() {
        synchronized (TaskExecutor.class) {
            if (!isScheduledServiceEnable()) {
                mScheduledService = new ScheduledThreadPoolExecutor(2, new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "TaskExecutor-111-");
                    }
                });

                mScheduledService.allowCoreThreadTimeOut(true);
            }
            return mScheduledService;
        }
    }

    private boolean isThreadServiceEnable() {
        return !(mThreadPoolExecutor == null
                || mThreadPoolExecutor.isShutdown() || mThreadPoolExecutor.isTerminated());
    }

    private ThreadPoolExecutor getThreadService() {
        synchronized (TaskExecutor.class) {
            if (!isThreadServiceEnable()) {
                mThreadPoolExecutor = new ThreadPoolExecutor(NORMAL_CORE_POOL_SIZE, NORMAL_MAX_POOL_SIZE,
                        NORMAL_KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "TaskExecutor-222-");
                    }
                });

                mThreadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return mThreadPoolExecutor;
        }
    }

}

/**
 * 线程池主要方法 new ThreadPoolExecutor（int corePoolSize,  核心线程数
 *                               int maximumPoolSize, 最大线程数
 *                               long keepAliveTime,
 *                               TimeUnit unit,
 *                               BlockingQueue<Runnable> workQueue,队列
 *                               ThreadFactory threadFactory）
 * 然后调用 ThreadPoolExecutor对象的submit方法
 *
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 *
 *
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 *
 *
 * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 *
 *
 * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 *
 * 核心线程数1，最大线程数1
 * new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())
 *
 * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
*  ThreadPoolExecutor(nThreads, nThreads,0L, TimeUnit.MILLISECONDS,
*                                       new LinkedBlockingQueue<Runnable>(),
*                                       threadFactory)
 *
 * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 * new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
 *
 *
 *newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
 * new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE,DEFAULT_KEEPALIVE_MILLIS, MILLISECONDS,new DelayedWorkQueue());
 *
 * ScheduledExecutorService
 * ScheduledThreadPoolExecutor
 * ExecutorService
 * ThreadPoolExecutor
*/
