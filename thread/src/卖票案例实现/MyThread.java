package 卖票案例实现;

public class MyThread implements Runnable {

    private int ticket = 100;
    private final static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //同步代码块  锁对象可以是任意对象
            synchronized (obj) {
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
            }
        }
    }
}
