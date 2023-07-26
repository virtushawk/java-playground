package com.virtushawk.app.thread;

import java.util.concurrent.*;

public class CallableThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = () -> {
            int sum = 0;
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }

            return sum;
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(callable);

        while (!result.isDone()) {
            System.out.println("Result is not yet finished!");
        }

        System.out.println("Result is acquired: " + result.get());


        System.exit(0);
    }
}
