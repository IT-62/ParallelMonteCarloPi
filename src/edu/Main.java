package edu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        System.out.println(new MonteCarloPi().getPiSequential());
        System.out.println(new MonteCarloPi().getPiParallel());
    }
}
