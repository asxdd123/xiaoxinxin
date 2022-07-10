package 锁对象唯一和同步方法;

public class MyThread implements Runnable{
    private  int ticket = 100;

    @Override
    public void run() {
        while (true){
            if("窗口一".equals(Thread.currentThread().getName())){
                boolean methods = methods();
                if(methods){
                    break;
                }
            }else{
                //同步代码块  锁对象可以是任意对象
                synchronized (this) {
                    if (ticket <= 0) {
                        System.out.println(Thread.currentThread().getName() + "票卖完了");
                        break;
                    } else {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        ticket--;
                        System.out.println(Thread.currentThread().getName() + "在卖票;还剩下" + ticket + "张票");
                    }
                }
            }

        }
    }

    // 同步方法
    private  synchronized boolean methods() {
        if (ticket <= 0) {
            System.out.println(Thread.currentThread().getName() + "票卖完了");
            return true;
        } else {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket--;
            System.out.println(Thread.currentThread().getName() + "在卖票;还剩下" + ticket + "张票");
        }
        return false;
    }
}
