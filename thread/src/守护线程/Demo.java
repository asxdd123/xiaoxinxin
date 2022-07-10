package 守护线程;

import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) {
        MyThread1 c1 = new MyThread1();
        MyThread1 c2 = new MyThread1();

        FutureTask<String> f1 = new FutureTask<>(c1);
        FutureTask<String> f2 = new FutureTask<>(c2);

        Thread t1 = new Thread(f1);
        Thread t2 = new Thread(f2);

        t1.setName("AAAA");
        t2.setName("BBBBBBB");
        t2.setDaemon(true);    //  意思就是把t2设置成守护线程,当ti结束后,t2也跟着结束

        t1.start();
        t2.start();
    }
}
