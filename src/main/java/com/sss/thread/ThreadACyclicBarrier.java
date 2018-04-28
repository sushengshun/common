package com.sss.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadACyclicBarrier {

    private static Random random = new Random(System.currentTimeMillis());
    private static ExecutorService executor = Executors.newFixedThreadPool(20);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(9);

    public static void main(String[] args) throws InterruptedException {
        //获取数组
        int[] data = query();
        //两次线程去操作逻辑
        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnAble(data, i, cyclicBarrier));

        }
        //保证所有线程执行完毕，再执行下面程序
        //latch.await();

        executor.shutdown();
        //获取处理过的数据
        System.out.println("取到数字" + Arrays.toString(data));
    }

    static class SimpleRunnAble implements Runnable {
        private final int[] data;
        private final int index;
        private final CyclicBarrier latch;

        SimpleRunnAble(int[] data, int index, CyclicBarrier latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.print(Thread.currentThread().getName() + "开始");

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int value = data[index];
            if (value % 2 == 0) {
                data[index] = value * 2;
            } else {
                data[index] = value * 10;
            }
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.print(Thread.currentThread().getName() + "结束");


        }
    }

    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

}
