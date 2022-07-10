package 线程的创建方式.Demo2;

/**
 * 第二种创建线程的方式   实现 Runnable接口
 */
public class MyRunable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程开始执行了" + i);
        }
    }
}




/**
 * 测试
 */
class DemoTest2 {
    public static void main(String[] args) {
        //相当于创建了一个参数
        MyRunable runable1 = new MyRunable();

        //创建了一个线程对象,并把参数传递给了线程对象
        //在线程启动之后,执行的代码就是参数里的run()方法
        Thread thread1 = new Thread(runable1);

        //开启线程
        thread1.start();



        MyRunable runable2 = new MyRunable();
        Thread thread2 = new Thread(runable2);
        thread2.start();
    }
}