package com.example.order.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式
 */
public class CreateThread {


    private static class NewThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread当前执行次数：" + i);
            }
        }
    }

    private static class NewRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable当前执行次数：" + i);
            }
        }
    }

    private static class NewCallable implements Callable {

        @Override
        public Object call() throws Exception {
            int a = 0;
            for (int i = 0; i < 10; i++) {
                a ++;
            }
            return "Callable当前执行次数" + a;
        }
    }

    public static void main(String[] args) throws Exception {

        new NewThread().start();

        new Thread(new NewRunnable()).start();

        NewCallable newCallable = new NewCallable();
        FutureTask futureTask = new FutureTask<>(newCallable);
        new Thread(futureTask).start();
        String o = (String) futureTask.get();

        System.out.println(o);


    }

}
