
import com.sun.scenario.effect.Offset;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * @Classname FileTest
 * @Description file类的使用
 * @Date 2021/3/3 9:38
 * @Created by ruler
 */
public class FileTest {

    @Test
    public void name() {
    }

    @Test
    //每次读入一个字符数组char[],写入
    public void testFileReader(){
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            fr = new FileReader(file);
            char[] chars = new char[5];

            int read = fr.read(chars);
            while (read != -1){
                String string = new String(chars, 0,read);
                read = fr.read(chars);
                System.out.print(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    //从内存写出测试,输出操作，是覆盖不是追加根据输出流最后面的参数，true文件存在直接在后面追加，false，覆盖
    public void testFileWriter() throws IOException {
        //从内存写出测试
        File file = new File("hello1.txt");
        FileWriter fw = new FileWriter(file,false);
        fw.write("i have a dream!\n");


        fw.close();

    }

    @Test
    //实现对图片的copy功能
    //实现对图片的copy功能
    //实现对图片的copy功能
    public void testFileInputStream1(){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File("1.jpg");
            File file2 = new File("2.jpg");

            fi = new FileInputStream(file);
            fo = new FileOutputStream(file2);

            byte[] buffer = new byte[1024];
            int read = fi.read(buffer);
            while (read != -1){
                fo.write(buffer,0,read);
                read = fi.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fi != null)
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fo != null)
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



    public void CopyByte(String srcPath,String destPath){
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            File file = new File(srcPath);
            File file2 = new File(destPath);

            fi = new FileInputStream(file);
            fo = new FileOutputStream(file2);

            byte[] buffer = new byte[1024];
            int read = fi.read(buffer);
            while (read != -1){
                fo.write(buffer,0,read);
                read = fi.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fi != null)
                    fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fo != null)
                    fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }







    @Test
    //测试复制功能的用时与使用
    //测试复制功能的用时与使用
    //测试复制功能的用时与使用
    public void testCopy1(){
        long Start = System.currentTimeMillis();
        System.out.println(Start);
        CopyByte("C:\\Users\\ruler\\Desktop\\data1.zip","C:\\Users\\ruler\\Desktop\\data2.zip");
        long Stop = System.currentTimeMillis();
        System.out.println(Stop);

        System.out.println(Stop-Start);

    }







    @Test
    //通过fileReader和fileWriter实现copy的功能
    //通过fileReader和fileWriter实现copy的功能
    //通过fileReader和fileWriter实现copy的功能
    public void testCopy(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File file2 = new File("hello2.txt");

            fr = new FileReader(file);
            fw = new FileWriter(file2,true);

            //数据的读入和写出操作
            char[] cbuf = new char[5];
            int read = fr.read(cbuf);
            while (read != -1){
                fw.write(cbuf,0,read);
                read = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }







    @Test
    public void test3() {
        FileReader fr = null;
        try {
//        1.实例化file类对象，指明操作文件
            File file = new File("hello.txt");
//        2.提供具体流
            fr = new FileReader(file);
//        3.数据读入,如果读到最后时返回-1
            int read = fr.read();
            while (read != -1){
                System.out.print((char)read);
                read = fr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //防止前面还未实例化，报空指针异常
                if(fr != null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



















    @Test
    public void test1(){
        File file = new File("hello.txt");
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getPath());
//        System.out.println(file.getName());
//
//        System.out.println(new Date(file.lastModified()));
//        System.out.println(file.length());

        file.renameTo(new File("123.txt"));
    }

    @Test
    public void test2() throws IOException {
        File file = new File("D:\\app\\idealU\\workspace\\learning\\day04");
        File file1 = new File(file.getParent(),"haha.txt");
        file1.delete();

        System.out.println(file1.exists());
    }
}
