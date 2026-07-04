package com.sneha.thread;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        long start = Instant.now().getEpochSecond();
        System.out.println("start time " + start);
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Thread> spawnedThreads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int s = i;

            Runnable one = () -> {
                try {
                    operation(a[s]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            };

            Thread t = new Thread(one);
            spawnedThreads.add(t);
            t.start();
        }
        for (Thread t : spawnedThreads) {
            t.join(); // The main thread freezes here until 't' enters the TERMINATED state
        }
        long endTimeInSeconds = Instant.now().getEpochSecond();
        System.out.println("endtime " + endTimeInSeconds);
        long totalExecutionTime = endTimeInSeconds - start;

        System.out.println("total " + (totalExecutionTime));
    }

    static void operation(int num) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(num * 2);
    }


}
