package com.sss.lock;

public class LockATest {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());

    }
}
