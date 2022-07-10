package 获取和设置线程名字;

public class Demo1 extends Thread{
    public Demo1() {
    }

    public Demo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // getName()  获取线程的名字    默认格式是: Thread-编号
            System.out.println(Thread.currentThread().getName() + "-----" + i);
        }
    }
}



class Test{
    public static void main(String[] args) {
        Demo1 demo = new Demo1("小花");   //设置名字时,要给线程添加无参和有参构造
        Demo1 demo2 = new Demo1("小强");


        demo.start();
        demo2.start();
    }
}

/**
 * 获取当前线程对象名
 */
class Test2{
    public static void main(String[] args) {
        // Thread.currentThread()  获取当前线程的对象
        String name = Thread.currentThread().getName();
        System.out.println(name);   // main
    }
}