import java.util.Properties;

public class ThreadDemo {
    public static void main(String[] args){
        myThread1 t1 = new myThread1();
        myThread2 t2 = new myThread2();
        //t1.start();

        //设置分线程t2的优先级
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i+
                    "-"+Thread.currentThread().getPriority());
        }

    }
}

class myThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class myThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 1){
                System.out.println(Thread.currentThread().getName()+":"+i+
                        "-"+Thread.currentThread().getPriority());
            }
        }
    }
}
