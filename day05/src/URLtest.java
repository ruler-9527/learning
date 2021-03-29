import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.Random;

/**
 * @Classname URLtest
 * @Description 统一资源定位符
 * @Date 2021/3/22 17:37
 * @Created by ruler
 */
public class URLtest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost/test/1");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("day05\\4.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        System.out.println("下载完成");

        //关闭资源
        fos.close();
        is.close();
        urlConnection.disconnect();
    }




    @Test
    public void testProperties() throws Exception{
        Properties pros = new Properties();
        FileInputStream fi = new FileInputStream(new File("jdbc.properties"));
        pros.load(fi);

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name"+name+","+"password"+password);

    }

    @Test
    public void test2(){
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "Person";
                break;
            case 2:
                classPath = "Person";
                break;

        }

        try {
            Object instance = getInstance(classPath);
            System.out.println(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //创建一个指定类的对象
//    classPath:指定类的全类名
    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

    @Test
    //获取属性field
    public void test3(){
        Class clazz = Person.class;

        //getFields可以获取当前运行时类与其父类的所有public权限的属性
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        System.out.println();

//getDeclaredFields()获取当前运行时类所有属性
        Field[] fields1 = clazz.getDeclaredFields();
        for(Field f : fields1){
            System.out.println(f);
        }
    }



}

class Person{
    public String name;
    public int age;
    private String home;

    public Person() {
    }

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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
