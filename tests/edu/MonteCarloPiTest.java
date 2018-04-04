package edu;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonteCarloPiTest {

    @Test
    public void getPiSequential() {
        long start = System.currentTimeMillis();
        System.out.println(MonteCarloPi.getPiSequential() + "- Sequential Pi");
        System.out.println(System.currentTimeMillis() - start + "ms (sequential)");
    }

    @Test
    public void getPiParallel() throws InterruptedException{
        long start = 0;
        System.out.println("Optimal count (?):" + Runtime.getRuntime().availableProcessors());
        for(int i = 1; i <= 8; i++) {
            start = System.currentTimeMillis();
            System.out.println("Parallel Pi: " + MonteCarloPi.getPiParallel(i));
            System.out.println(System.currentTimeMillis() - start + "ms (parallel)(" + i +"threads)");
            System.out.println("------------------------------");
        }
    }
}