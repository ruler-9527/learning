package demo1;

/**
 * @Classname SeasonTest
 * @Description 自定义枚举类
 * @Date 2021/2/22 14:25
 * @Created by ruler
 */
public class SeasonTest {
    public static void main(String[] args){
        Season s = Season.SPRING;
        Season[] s1 = Season.values();
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }



//        System.out.println(Season.SPRING);
//        System.out.println(s);
//        System.out.println(Season.SUMMER);
    }
}

//方式二：
enum  Season {
    SPRING("春天","吃饺子1"),
    SUMMER("夏天","吃雪糕");

//声明season属性
    private final String name;
    private final String describe;
//私有化类的构造器
    private Season(String name,String describe){
        this.describe = describe;
        this.name = name;
    }
    



    public String getName() {
        return name;
    }

    public String getDescribe() {
        return describe;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}








//方式一：
//class Season {
//    private final String name;
//    private final String describe;
//
//    public Season(String name,String describe){
//        this.describe = describe;
//        this.name = name;
//    }
//
//    public static final Season SPRING = new Season("春天","吃饺子");
//    public static final Season SUMMER = new Season("夏天","吃雪糕");
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescribe() {
//        return describe;
//    }
//
//    @Override
//    public String toString() {
//        return "Season{" +
//                "name='" + name + '\'' +
//                ", describe='" + describe + '\'' +
//                '}';
//    }
//}
