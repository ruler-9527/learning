import org.junit.Test;

import javax.sound.midi.Soundbank;

//创建多线程方式二，实现runnable接口
public class RunnableTest {
    public static void main(String[] args){
        RunnableDemo rt = new RunnableDemo();
        Thread t1 = new Thread(rt);
        t1.start();

    }


}


class RunnableDemo implements Runnable{


    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }

}
