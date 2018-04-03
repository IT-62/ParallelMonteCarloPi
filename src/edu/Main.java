package edu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        long startTime = System.currentTimeMillis();
        System.out.println(new MonteCarloPi().getPiSequential());
        System.out.println(System.currentTimeMillis() - startTime + "мс прошло (последовательно)");
        startTime = System.currentTimeMillis();
        System.out.println(new MonteCarloPi().getPiParallel());
        System.out.println(System.currentTimeMillis() - startTime + "мс прошло (параллельно)");
    }
}
