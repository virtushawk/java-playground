package com.virtushawk.app.thread;

import java.util.ArrayList;
import java.util.List;

public class ThreadWithSynchronize {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        list.add(0);

        Runnable sumThread = () -> {
            for (int i = 0; i <= 100; i++) {
                synchronized (list) {
                    list.add(0, list.get(0) + i);
                }
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
