package edu;

import java.util.Random;

public class MonteCarloPi {
    private final static long iterationsTotal = (long) 1e7;

    public static double getPiSequential() {
        double x, y;
        long passed = 0;
        Random rnd = new Random();
        for(int i = 0; i < iterationsTotal; ++i) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if((x * x + y * y) < 1.0)
                passed++;
        }
        return ((double) passed / iterationsTotal) * 4.0;
    }

    public static double getPiParallel(int threadsCount) throws InterruptedException {
        int n = threadsCount;
        long passedTotal = 0, iterationsPerProcess = iterationsTotal / n;
        CustomThread[] customThreads = new CustomThread[n];
        for(int i = 0; i < n; i++) {
            customThreads[i] = new CustomThread(iterationsPerProcess);
            customThreads[i].start();
        }
        for (CustomThread customThread : customThreads) {
            customThread.join();
            passedTotal += customThread.passed;
        }
        return ((double) passedTotal / iterationsTotal) * 4.0;
    }
}
