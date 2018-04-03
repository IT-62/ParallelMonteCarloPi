package edu;

import java.util.Random;

public class MonteCarloPi {
    private final long iterationsTotal = (long) 1e9;

    public double getPiSequential() {
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

    public double getPiParallel() throws InterruptedException {
        int n = Runtime.getRuntime().availableProcessors();
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
