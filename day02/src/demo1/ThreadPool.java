package demo1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Classname ThreadPool
 * @Description 创建线程的方法——线程池
 * @Date 2021/2/21 15:40
 * @Created by ruler
 */
public class ThreadPool {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);

        service.execute(new NumberThread());//适用于runnable
        //service.submit();//适用于callable

        //关闭线程池
        service.shutdown();

    }
}

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0){
                System.out.println(i);
            }
        }

    }
}
