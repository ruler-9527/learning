/**
 * @Classname StaticProxyTest
 * @Description 静态代理
 * @Date 2021/3/25 16:30
 * @Created by ruler
 */
interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类对象来实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");

        factory.produceCloth();

        System.out.println("代理工厂做一些后续收尾工作");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("nike工厂生产一批运动服");
    }
}


public class StaticProxyTest {
    public static void main(String[] args){
        //创建被代理类对象
        NikeClothFactory nike = new NikeClothFactory();

        //创建代理类对象
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
