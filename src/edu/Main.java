package edu;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        long startTime, finishTime;
        double seqPi, parPi;
        startTime = System.currentTimeMillis();
        seqPi = new MonteCarloPi().getPiSequential();
        finishTime = System.currentTimeMillis() - startTime;
        System.out.println(finishTime + "ms (sequential)");
        startTime = System.currentTimeMillis();
        parPi = new MonteCarloPi().getPiParallel(4);
        finishTime = System.currentTimeMillis() - startTime;
        System.out.println(finishTime + "ms (parallel)");
        System.out.println("Sequential Pi: " + seqPi);
        System.out.println("Parallel Pi: " + parPi);
    }
}
