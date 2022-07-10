package 线程的创建方式.Demo3;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCalable implements Callable<Integer> {

    // 跟run()方法一样,也是封装线程要执行的代码
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("你好骚" + i);
        }
        //返回值就是线程执行完毕之后的结果
        return 1;
    }
}




/**
 * 测试
 */
class DemoTest3 {
    public static void main(String[] args) throws Exception {
        //相当于创建了一个参数
        //线程开启之后需要执行里面的call()方法
        MyCalable calable = new MyCalable();

        // 相当于一个中间件,用来进过度,因为FutureTask底层实现了Runnable接口
        // FutureTask<?>  参数类型要跟MyCalable中的参数类型要保持一致
        // 可以获取线程完成之后的结果,也可以作为参数传递给Thread
        FutureTask<Integer> task = new FutureTask<>(calable);

        //创建线程对象
        Thread thread = new Thread(task);

        //开启线程
        thread.start();

        Integer integer = task.get();   // 获取线程执行完毕之后的结果
        System.out.println(integer);




        MyCalable cal = new MyCalable();
        FutureTask<Integer> taske = new FutureTask<>(cal);
        Thread thr = new Thread(taske);
        thr.start();
        Integer integer1 = task.get();
        System.out.println(integer1);
    }
}