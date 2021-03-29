import org.junit.Test;

import java.io.*;
import java.nio.Buffer;

/**
 * @Classname BufferTest
 * @Description TODO
 * @Date 2021/3/12 11:15
 * @Created by ruler
 */
public class BufferTest {
    @Test
    public void test1(){
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            //1.创建文件对象
            File f1 = new File("1.jpg");
            File f2 = new File("2.jpg");

            //2.创建流
            FileInputStream fi = new FileInputStream(f1);
            FileOutputStream fo = new FileOutputStream(f2);

            bi = new BufferedInputStream(fi);
            bo = new BufferedOutputStream(fo);

            //3.读写操作
            byte[] buff = new byte[5];
            int read = bi.read(buff);
            while (read != -1){
                bo.write(buff,0,read);
                read = bi.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bo != null){
                try {
                    bo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bi != null){
                try {
                    bi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        //关闭外层流的时候内层的也会一并关闭，下面两个被包装的节点流关闭可省略
//        fo.close();
//        fi.close();
    }






    @Test
    //实现图片的加密
    //实现图片的加密
    //实现图片的加密
    public void test2() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream("1.jpg");
            fo = new FileOutputStream("2.jpg");

            byte[] bytes = new byte[20];
            int read = fi.read(bytes);
            while (read != -1){
                //加密核心
                for (int i = 0; i < read; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fo.write(bytes,0,read);
                read = fi.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    @Test
    //实现图片的解密
    //实现图片的解密
    //实现图片的解密
    public void test3() {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        try {
            fi = new FileInputStream("2.jpg");
            fo = new FileOutputStream("2解密.jpg");

            byte[] bytes = new byte[20];
            int read = fi.read(bytes);
            while (read != -1){
                //加密核心
                for (int i = 0; i < read; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fo.write(bytes,0,read);
                read = fi.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fo != null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fi != null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
