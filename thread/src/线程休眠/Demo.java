package 线程休眠;

public class Demo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // 让线程休眠3秒,  单位是毫秒
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }
}



class Test{
    public static void main(String[] args) {
        Demo demo1 = new Demo();
        Demo demo2 = new Demo();

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);

        t1.start();
        t2.start();
    }
}