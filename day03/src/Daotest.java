import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname Daotest
 * @Description TODO
 * @Date 2021/2/26 14:40
 * @Created by ruler
 */
public class Daotest {
    @Test
    public void test(){
        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(1,"111");
        map.put(2,"222");
        map.put(3,"333");
        System.out.println(map.containsKey(2));


    }

    public static void main(String[] args){
        dao<Integer> dao = new dao<>();
        dao.save(1,333);
        System.out.println(dao.getMap());

    }


}

class dao<T>{
    private Map<Integer,T> map = new HashMap<>();

    public void save(Integer id, T entity){
        map.put(id,entity);
    }

    public Map<Integer, T> getMap() {
        return map;
    }
}
