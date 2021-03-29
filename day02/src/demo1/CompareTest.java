package demo1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Classname CompareTest
 * @Description TODO
 * @Date 2021/2/22 10:11
 * @Created by ruler
 */
public class CompareTest {
    public static void main(String[] args){
//        String[] s = new String[]{"aa","cc","ff","bb"};
//        Arrays.sort(s);
//        System.out.println(Arrays.toString(s));


    }

    @Test
    public void test1(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("zzz",111);
        arr[1] = new Goods("zzz",666);
        arr[2] = new Goods("zzz",444);
        arr[3] = new Goods("zzz",333);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }


}


