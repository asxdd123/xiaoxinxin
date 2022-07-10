package 设置线程的优先级;

public class Test {
    public static void main(String[] args) {
        /**
         * getPriority()  获取线程优先级
         * setPriority()  设置线程优先级   1-10 默认优先级是 5   虽然设置了优先级,但是优先级高的也不一定先执行完
         *
         */

        MyThread1 r1 = new MyThread1();
        Thread t1 = new Thread(r1);
        MyThread2 r2 = new MyThread2();
        Thread t2 = new Thread(r2);


        t1.setPriority(8);
        t1.setName("AAAA");
        t1.start();


        t2.setPriority(6);
        t2.setName("BBBBB");
        t2.start();
    }
}
