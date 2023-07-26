package com.virtushawk.app.thread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadWithSynchronizedCollection {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(0);

        Runnable sumThread = () -> {
            for (int i = 0; i <= 100; i++) {
                int number = list.get(0);
                list.add(0, number + i);
            }
        };

        Thread thread1 = new Thread(sumThread);
        Thread thread2 = new Thread(sumThread);
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list.get(0));
    }
}
