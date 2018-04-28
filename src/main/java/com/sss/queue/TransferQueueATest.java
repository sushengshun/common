package com.sss.queue;

import com.sss.model.User;

import java.util.concurrent.*;

public class TransferQueueATest {

    //private static LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(10);

    private static TransferQueue transferQueue = new LinkedTransferQueue();

    private static ExecutorService es = Executors.newFixedThreadPool(5);

    public static void add(User user){
        //不阻塞，队列满了返回false
        //boolean flag = blockingQueue.offer(user);
        //System.out.println(flag);
        //阻塞线程
        try {
            transferQueue.put(user);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(transferQueue.size());
    }

    public static void work(){
        User user = (User)transferQueue.poll();
        System.out.println(user.getName());
    }

    private class ThreadA implements Runnable{

        @Override
        public void run() {
            while (true){
                String threaName = Thread.currentThread().getName();
                //System.out.println(threaName);
                    /*User user = null;
                    if(blockingQueue.poll() != null){
                        user = (User)blockingQueue.poll();
                        System.out.println(threaName+"打印线程"+user.getName());
                    }else{
                        System.out.println(threaName+"打印线程"+"null");
                    }*/
                try {
                    User user = (User)transferQueue.take();
                    System.out.println(threaName+"打印线程"+user.getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    private static int i = 0;

    public void test(){
        //System.out.println(i++);
        ThreadA a = new TransferQueueATest.ThreadA();
        es.execute(a);
    }

    public static void main(String[] args) throws InterruptedException {
        TransferQueueATest blockQueueTestA = new TransferQueueATest();

        for(int i=0;i<5;i++){
            blockQueueTestA.test();
        }

        for(int i=0;i<100;i++){
            User user = new User();
            user.setName("user-name"+i);
            add(user);
        }
        System.out.println("111");


    }

}
