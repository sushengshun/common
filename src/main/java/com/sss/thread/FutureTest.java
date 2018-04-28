package com.sss.thread;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FutureTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(5);


    private static AtomicInteger integer = new AtomicInteger(0);

    private class ThreadA implements Runnable{

        public void run() {
                try {
                    //int i = 1/0;
                    int i = integer.getAndIncrement();
                    System.out.println(i);
                    if(i%10 == 0){
                        throw new NullPointerException("exception");
                    }
                    System.out.println(i+"----------");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    private class ThreadB implements Callable{


        public Object call() throws Exception {
            try {
                //int i = 1/0;
                int i = integer.getAndIncrement();
                System.out.println(i);
                if(i>0 && i%10 == 0){
                    throw new NullPointerException("exception");
                }
                System.out.println(i+"----------");
                return i;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "er";
        }
    }

    public void t(){
        ThreadA threadA = new FutureTest.ThreadA();
        Future future = executorService.submit(threadA);
        try {
            String s =(String) future.get();
            System.out.println(s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void c(){
        ThreadB threadB = new FutureTest.ThreadB();
        Future future = executorService.submit(threadB);
        try {
            String s =(String) future.get(1000,TimeUnit.MILLISECONDS);
            System.out.println(s);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();

       /* for(int i =0;i<100;i++){
            futureTest.t();
        }*/
        for(int i =0;i<100;i++){
            futureTest.c();
        }
        //futureTest.c();
    }



    }

