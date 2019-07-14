package com.example.thread;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class thradTest extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行Run中");
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}

class ThreadTest implements Runnable{
    private static volatile int num = 100000;
    String name;

    public ThreadTest(String name) {
            this.name=name;
    }

    //实现Runnable接口，实现run()方法
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行Run中");
        /*for (int i=1; i<1000;i++){
            num--;
            System.out.print(num+"---");
        }*/
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MyTask [name=" + name + "]";
    }
}

class NameTreadFactory implements ThreadFactory {

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
        System.out.println(t.getName() + " has been created");
        return t;
    }
}

class MyIgnorePolicy implements RejectedExecutionHandler {

    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        doLog(r, e);
    }

    private void doLog(Runnable r, ThreadPoolExecutor e) {
        // 可做日志记录等
        System.err.println( r.toString() + " rejected");
//          System.out.println("completedTaskCount: " + e.getCompletedTaskCount());
    }
}

public  class ExtendThread{
    public static void main (String[] args) throws InterruptedException, IOException {
        //继承类实现
        /*new thradTest().start();
        new thradTest().start();
        new thradTest().start();
        new thradTest().start();*/

        //接口实现
        System.out.println("----------------------------");
        /*
        ThreadTest runnable = new ThreadTest();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();*/
        //线程池创建
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                workQueue, threadFactory, handler);
        executor.prestartAllCoreThreads();

        for (int i = 1; i <= 10; i++) {
            ThreadTest runnable = new ThreadTest(Integer.toString(i));
            executor.execute(runnable);
        }
        //System.in.read(); //阻塞主线程

    }

}
