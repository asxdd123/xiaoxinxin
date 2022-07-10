package 守护线程;

import java.util.concurrent.Callable;

public class MyThread2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "==========" + i);
        }
        return Thread.currentThread().getName() + "线程执行完毕";
    }
}
