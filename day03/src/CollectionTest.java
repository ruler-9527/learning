import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @Classname CollectionTest
 * @Description 集合知识点(子接口List、Set)
 * @Date 2021/2/22 16:05
 * @Created by ruler
 */
public class CollectionTest {


    @Test
    public void test(){
        Collection c = new ArrayList();
        c.add("11");
        c.add(new Date());
        c.add(123);
        System.out.println(c);

        //判断当前集合中是否含有1234改obj返回一个boolean值
        boolean b = c.contains(1234);
        System.out.println(b);

        boolean b1 = c.contains("11");
        System.out.println(b1);

        //集合到数组的转换
//        Object[] obj = c.toArray();
//        for (int i = 0; i < obj.length; i++) {
//            System.out.println(obj[i]);
//        }
        System.out.println("-------");

        //通过迭代器来遍历collection里的元素，方法1
        //Iterator it = c.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next().getClass());

        //推荐使用的方法2(next()方法使得指针下移，指针一开始指向一个数据的前面)
//        Iterator it = c.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        System.out.println(Collection.class);

        //增强for循环，foreach
//        for (Object obj: c){
//            System.out.println(obj);
//        }

        Collection c2 = new ArrayList();
        c2.add("123");
        c2.add("asd");
        c2.add("456");
        System.out.println(c2);



    }




}
