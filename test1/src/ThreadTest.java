public class ThreadTest{
    //多线程的创建方式1：继承thread类
    public static void main(String[] args){
        myThread mt = new myThread();
        mt.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"hello");
        }
    }

}

class myThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
