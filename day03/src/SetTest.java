import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @Classname SetTest
 * @Description set接口用来存储无序的不可重复的数据
 * @Date 2021/2/23 11:07
 * @Created by ruler
 */

public class SetTest {
    @Test
    public void test(){
        Set set = new HashSet();
        set.add(123);
        set.add(new Date());
        set.add("asd");
        set.add(111);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


    //treeset只能添加相同类型的数据，且在遍历的时候按照从小到大遍历出来
    @Test
    public void test2(){
        TreeSet set = new TreeSet();
        set.add(new Person("张三",11));
        set.add(new Person("张三1",12));
        set.add(new Person("张三2",13));
        set.add(new Person("张三3",14));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test3(){
        HashMap hashMap = new HashMap();

        hashMap.put(1,"2名");
//相同的key，后面的value会修改前面的value，key值只能唯一
        hashMap.put(1,"大名");
        hashMap.put(2,"er名");
        hashMap.put(3,"3名");
        hashMap.put(4,"4名");

        //遍历所有的key
        Set set = hashMap.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //遍历所有values
        Collection values = hashMap.values();
        Iterator iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有key-values
        Set set1 = hashMap.entrySet();
            Iterator iterator1 = set1.iterator();
            while (iterator1.hasNext()){
                Object object = iterator1.next();
                //entrySet集合中的元素都是entry
                Map.Entry entry = (Map.Entry) object;
                System.out.println(entry.getKey()+"--->"+entry.getValue());

        }


        System.out.println(hashMap);
        System.out.println(hashMap.get(2));


    }
}









class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
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
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p = (Person) o;
            return -this.name.compareTo(p.name);
        }else {
            throw new RuntimeException("输入类型不匹配");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


