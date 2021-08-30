package com.spike.demoservicea;

/**
 * date: 2021/8/19
 * author: Spike
 * description:
 */
public class TTT {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            /**
             * If this thread was constructed using a separate
             * <code>Runnable</code> run object, then that
             * <code>Runnable</code> object's <code>run</code> method is called;
             * otherwise, this method does nothing and returns.
             * <p>
             * Subclasses of <code>Thread</code> should override this method.
             *
             * @see #start()
             * @see #stop()
             * @see #Thread(ThreadGroup, Runnable, String)
             */
            @Override
            public void run() {
                System.out.println("t线程开始执行---中断标志位："+Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(10000000);
                    System.out.println("t线程第一次睡眠正常结束---中断标志位：Thread.currentThread().isInterrupted()");
                } catch (InterruptedException e) {
                    System.out.println("t线程第一次被中断了---中断标志位："+Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("打断后重新设置中断标志位为true");
                }
                System.out.println("t线程睡醒了，退出---中断标志位："+Thread.currentThread().isInterrupted());

                try {
                    System.out.println("t线程第二次睡眠开始---中断标志位："+Thread.currentThread().isInterrupted());
                    Thread.sleep(100000L);
                    System.out.println("t线程第二次睡眠正常结束---中断标志位：Thread.currentThread().isInterrupted()");
                } catch (InterruptedException e) {
                    System.out.println("t线程第二次被中断了---中断标志位："+Thread.currentThread().isInterrupted());
                }
            }
        };
        t.start();
        Thread.sleep(1000);
        System.out.println("第1次中断t线程");
        t.interrupt();
        System.out.println("等待5秒");
//        Thread.sleep(5000);
//        System.out.println("第2次中断t线程");
//        t.interrupt();
        System.out.println("主线程运行完毕");


    }
}
