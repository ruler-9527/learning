

class Window1 implements Runnable{
    private int ticket = 1000;

    //这里锁必须声明再次确保多个线程共用一把锁
    Object obj = new Object();

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (ticket > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    System.out.println(Thread.currentThread().getName() + ":卖出票号" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}

public class WindowTest1 {
    public static void main(String[] args){
        Window1 w = new Window1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}