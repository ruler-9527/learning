import javax.sound.midi.Soundbank;

public class Person {
    static int ID = 10010;
    private String name = "tom";
    private int age = 18;



    public Person(){}

    static{


        System.out.println("静态代码块直接执行");
    }

    {
        zxc = 1;
        System.out.println("非静态代码块");
    }
    int zxc = 2;

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

    public void setAge(int age) {
        this.age = age;
    }

    public void getAge(){
        int age = 1;
        System.out.println("方法中的age="+age);
        System.out.println(this.age);
    }



}
