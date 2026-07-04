package com.sneha.thread;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = Instant.now().getEpochSecond();
        System.out.println("start time " + start);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Future<Integer>> futuresList = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            int s = i;

            Callable<Integer> task = () -> operation(a[s]);

            Future<Integer> future = executor.submit(task);
            futuresList.add(future);

        }
        for (Future<Integer> future : futuresList) {
           int result = future.get();
            System.out.println("result " + result);
        }
        executor.shutdown();
        long endTimeInSeconds = Instant.now().getEpochSecond();
        System.out.println("endtime " + endTimeInSeconds);
        long totalExecutionTime = endTimeInSeconds - start;

        System.out.println("total " + (totalExecutionTime));
    }

    static int operation(int num) throws InterruptedException {
        Thread.sleep(1000);
        int result = num * 2;
        return result;
    }

}

