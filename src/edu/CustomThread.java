package edu;

import java.util.Random;

public class CustomThread extends Thread {
    private long iterForProcCount;
    MonteCarloPi monteCarloPi;
    public CustomThread(long iterForProcCount, MonteCarloPi monteCarloPi) {
        this.iterForProcCount = iterForProcCount;
        this.monteCarloPi = monteCarloPi;
    }

    public void run() {
        Random rnd = new Random();
        double x, y;
        long passed = 0;
        for(int i = 0; i < iterForProcCount; i++) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if(MonteCarloPi.isInCircle(x, y)) passed++;
        }
        monteCarloPi.incPassed(passed);
    }
}
