package com.example.order.thread;

public class InterruptThread {


    private static class InterruptDemo extends Thread {

        @Override
        public void run() {
            while (!isInterrupted()) {
                System.out.println("abc---");
            }
            System.out.println("执行结束---");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        InterruptDemo interruptDemo = new InterruptDemo();
        interruptDemo.start();
        Thread.sleep(1);
        interruptDemo.interrupt();
    }

}
