/**
 * @Classname BankTest
 * @Description 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @Date 2021/2/21 11:44
 * @Created by ruler
 */
public class BankTest {

}


//单例式懒汉模式(synchronized同步)
class Bank{
    private Bank(){

    }
    private static Bank instance = null;

    public static Bank getInstance(){
        //方式一：效率略差(同步代码块)
//        synchronized (Bank.class){
//            if (instance == null){
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方式二
        if(instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
