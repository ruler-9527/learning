//使用同步方法解决实现runnable接口的线程安全问题

public class WindowTest3 {
    public static void main(String[] args){
        Windows3 w = new Windows3();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.setName("口1");
        w2.setName("口2");
        w3.setName("口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Windows3 implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    public synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖出票号" + ticket);
            ticket--;
        }
    }

}
