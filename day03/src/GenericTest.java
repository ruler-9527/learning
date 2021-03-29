import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname GenericTest
 * @Description 泛型测试，泛型就是类似标签的东西
 * @Date 2021/2/24 17:09
 * @Created by ruler
 */


public class GenericTest {

    @Test//集合中未使用的泛型的时候
    public void test(){
        ArrayList arl = new ArrayList();
        arl.add(88);
        arl.add(100);
        arl.add(60);
        arl.add(74);
        //问题1：类型不安全
        arl.add("tom");

        for (Object obj : arl){
            //问题2：强转时候，可能出现classcastexception，类型转换异常
            int score= (Integer) obj;
            System.out.println(score);
        }
    }

    @Test//集合中使用的泛型的时候
    public void test1(){
        ArrayList<Integer> arl = new ArrayList<Integer>();
        arl.add(88);
        arl.add(100);
        arl.add(12);
        arl.add(74);
        //强制限制只能放进integer类型，编译时就能查出错误
        //arl.add("tom");

        for (Integer integer : arl){
            //避免了强转
            int score= integer;
            System.out.println(score);
        }
    }

    @Test
    public void test3(){
        Dog d = new Dog("aaa",12);
        int age = d.getAge();
        System.out.println(age);

        System.out.println(d);
    }

    @Test//泛型
    public void test4(){
        //这里？是通配符
        List<?> list1 = null;


        List<String> list = new ArrayList<>();
        list.add("hacker");
        list.add("123");
        list.add("aa");

        list1 = list;

        System.out.println(list1);
        System.out.println(list);
        System.out.println(list.equals(list1));
        

        System.out.println(list1.get(0));
        list1.remove(0);
        System.out.println(list1);
        System.out.println(list);
    }
}

class Dog<String>{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public java.lang.String toString() {
        return "Dog{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
