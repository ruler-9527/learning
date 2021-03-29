import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Classname ProxyTest
 * @Description TODO
 * @Date 2021/3/25 16:54
 * @Created by ruler
 */
interface Human{
    String getBelief();
    void eat(String food);

}


//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "山巅自相逢";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+ food);
    }
}


class ProxyFactory{
    public static Object getProxyInstance(Object obj){//obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object obj;
    public void bind(Object obj){
        this.obj = obj;
    }


    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke（）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        Object returnValue = method.invoke(obj, args);
        return returnValue;
    }
}


public class ProxyTest {
    public static void main(String[] args){
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance.getBelief());
        proxyInstance.eat("小汉堡");
    }

}


