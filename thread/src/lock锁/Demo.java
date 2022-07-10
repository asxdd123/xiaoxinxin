package lock锁;



public class Demo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);

        t1.setName("窗口一");
        t2.setName("窗口二");


        t1.start();
        t2.start();
    }
}
