package 线程的创建方式.Demo1;

/**
 * 实现多线程测试
 */
public class DemoTest1 {
    public static void main(String[] args) {
        //创建了两个线程
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        //开启了两个线程
        t1.start();
        t2.start();

        //运行结果得知: 两个线程随机交替运行


//        t1.run();   仅仅是封装了线程要执行的代码,直接调用相当于普通的方法调用,并没有开启线程
//        t2.start();  启动线程,然后有jvm调用此线程的run()方法
    }
}



/**
 * 第一种方式     继承Thread类重写run方法
 */
 class MyThread extends Thread{

    // run方法只是封装了线程要运行的程序
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程执行了" + i);
        }
    }
}