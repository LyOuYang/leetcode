package medium;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private static ReentrantLock LOCK_1 = new ReentrantLock();
    private static ReentrantLock LOCK_2 = new ReentrantLock();
    static CountDownLatch latch = new CountDownLatch(3);
    static volatile boolean flag = false;


    public static void main(String[] args) {
        Runnable r1 = () -> {
            LOCK_1.lock();
            System.out.println("r1 get lock1");
            try {
                LOCK_2.lockInterruptibly();
            } catch (InterruptedException e) {
//                LOCK_2.unlock();
                System.out.println("r1 lock2 interrupt");
            }
            System.out.println("r1 get lock2");
            LOCK_1.unlock();
            System.out.println("r1 end");
        };

        Runnable r2 = () -> {
            LOCK_2.lock();
            System.out.println("r2 get lock2");
            LOCK_1.lock();
            System.out.println("r2 get lock1");
            LOCK_1.unlock();
            LOCK_2.unlock();
            System.out.println("r2 end");
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

        Runnable r3 = () -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                int i = scanner.nextInt();
                if (i != 1) {
                    System.out.println("wait...");
                    continue;
                }
                System.out.println("start unlock LOCK_1");
                if (LOCK_1.isLocked()) {
                    t1.interrupt();
                    System.out.println("unlock success");
                }
            }
        };
        Thread t3 = new Thread(r3);
        t3.start();
    }

}