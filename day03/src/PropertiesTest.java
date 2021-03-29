import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Classname PropertiesTest
 * @Description TODO
 * @Date 2021/2/23 17:17
 * @Created by ruler
 */
public class PropertiesTest {
    public static void main(String[] args) throws Exception{
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");

        p.load(fis);
        String name = p.getProperty("password");
        System.out.println(name);
        System.out.println(p.get("name"));

        fis.close();
    }
}
