import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname CollectionsTest
 * @Description TODO
 * @Date 2021/2/23 17:45
 * @Created by ruler
 */
public class CollectionsTest {
    @Test
    public void tees1(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
    }
}
