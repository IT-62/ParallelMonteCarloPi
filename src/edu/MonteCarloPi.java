package edu;

import java.util.ArrayList;
import java.util.Random;

public class MonteCarloPi {
    private final long iterationsCount = (long) 1e8;
    private long parallelPassed;
    public static boolean isInCircle(double x, double y) {
        return (x*x + y*y) < 1.0;
    }

    public double getPiSequential() {
        double x = 0.0, y = 0.0;
        long passed = 0;
        Random rnd = new Random();
        for(int i = 0; i < iterationsCount; ++i) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if(isInCircle(x, y))
                passed++;
        }
        return  ((double) passed / iterationsCount) * 4.0;
    }

    public double getPiParallel() throws InterruptedException {
        int n = Runtime.getRuntime().availableProcessors();
        long iterForProcCount = iterationsCount / n;
        parallelPassed = 0;
        ArrayList<CustomThread> customThreads = new ArrayList<>();
        for(int i = 0; i < n; i++)
            customThreads.add(new CustomThread(iterForProcCount, this));

        for (CustomThread customThread : customThreads) {
            customThread.start();
        }
        for (CustomThread customThread : customThreads) {
            customThread.join();
        }
        return ((double) parallelPassed / iterationsCount) * 4.0;
    }

    public synchronized void incPassed(long curPassed) {
        parallelPassed+=curPassed;
    }
}
