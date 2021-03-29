package demo1;

/**
 * @Classname AccountTest
 * @Description 银行账户存钱练习，多线程
 * @Date 2021/2/21 14:30
 * @Created by ruler
 */
class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //账户的存钱方法
    public synchronized void deposit(double amt){
        //释放被阻塞的线程
        notify();
        if (amt >0){
            balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"存钱成功，存入"+amt+"$,余额："+balance+"$");

            try {
                //执行wait释放锁，并阻塞当前线程
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct.deposit(1000);
        }

    }
}

public class AccountTest {
    public static void main(String[] args){
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("张三");
        c2.setName("fff");

        c1.start();
        c2.start();
    }
}
