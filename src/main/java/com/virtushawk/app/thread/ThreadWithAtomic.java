package com.virtushawk.app.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWithAtomic {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        Runnable sumThread = () -> {
            for (int i = 0; i <= 100; i++) {
                atomicInteger.addAndGet(i);
            }
        };

        Thread thread1 = new Thread(sumThread);
        Thread thread2 = new Thread(sumThread);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(atomicInteger.get());
    }
}
