package 设置线程的优先级;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "=====" + i);
        }
    }
}
