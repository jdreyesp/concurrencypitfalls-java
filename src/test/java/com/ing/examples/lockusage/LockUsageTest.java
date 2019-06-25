package com.ing.examples.lockusage;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

import static org.junit.Assert.assertTrue;

public class LockUsageTest {

    LockUsage<String> lockUsage = new LockUsage<>();
    CyclicBarrier barrier = new CyclicBarrier(101);

    @Test
    public void theListShouldNotHaveCorrectNumberOfElements() {
        try {

            for(int i=0; i< 100; i++) {
                new LockPublisher().start();
            }

            barrier.await();
            barrier.await();

            System.out.println(String.format("Oh No! I have %s elements. I should only have 1!", lockUsage.list.size()));
            assertTrue(lockUsage.list.size() > 1);

        } catch (Exception e) {

        }
    }

    class LockPublisher extends Thread {

        @Override
        public void run() {
            try {

                barrier.await();
                lockUsage.putIfAbsent("Hello");
                barrier.await();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
