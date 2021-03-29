/**
 * @Classname ExtendsTest
 * @Description TODO
 * @Date 2021/2/26 15:38
 * @Created by ruler
 */
public class ExtendsTest {
    public static void main(String[] args){
//        Dog1 dog1 = new Dog1();
//
//        dog1.run();
//        dog1.name = "123";

        Animal dog1 = new Dog1();
        System.out.println(dog1.getClass());
        dog1.run();

    }
}

class Animal {
    public String name;
    public int id;
    public void run(){
        System.out.println("aaa");
    }
}

class Dog1 extends Animal{
    public void run(){
        System.out.println("wwww");
    }


}
