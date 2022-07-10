package lock锁;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread implements Runnable {

    private int ticket = 100;
    private final  static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
           lock.lock();  // lock锁开启
            if (ticket <= 0) {
                System.out.println(Thread.currentThread().getName() + "票卖完了");
                break;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticket--;
                System.out.println(Thread.currentThread().getName() + "在卖票;还剩下" + ticket + "张票");
            }
            lock.unlock();  // lock锁关闭
        }
    }
}
