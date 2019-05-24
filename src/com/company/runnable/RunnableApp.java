package com.company.runnable;

public class RunnableApp {

    public static void main(String[] args) {
        ThreadDemo R1 = new ThreadDemo("THR-1");
        R1.start();

        ThreadDemo R2 = new ThreadDemo("THR-2");
        R2.start();
    }
}