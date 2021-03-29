import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname LockTest
 * @Description 解决线程安全方式3.lock
 *
 * synchronized机制与lock机制的不同点：
 *synchronized机制在执行完相应的同步代码之后，自动的释放同步监视器
 * lock需要手动的启动同步（lock（）），同时结束同步也需要手动的实现unlock（）
 *
 * @Date 2021/2/21 12:29
 * @Created by ruler
 */
public class LockTest {
    public static void main(String[] args){
        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("口1");
        t2.setName("口2");
        t3.setName("口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable{
    private int ticket = 10;

    //1.实例化ReetrantLock
    private ReentrantLock lock = new ReentrantLock(true);//这里设置参数true表示公平，先进先出

    @Override
    public void run() {
        while (true){
            try {
                //2.调用lock()方法
                lock.lock();

                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":卖出票号"
                            +ticket);
                    ticket--;
                }else{
                    break;
                }
            }finally {
                //3.调用解锁unlock()
                lock.unlock();
            }
        }
    }
}
