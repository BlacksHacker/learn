package proxy.dynamicJdk;

import proxy.staticProxy.OrderService;
import proxy.staticProxy.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy2 implements InvocationHandler {

    private Object target;

    public DynamicProxy2(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before and before.....");
        Object invoke = method.invoke(target, args);
        System.out.println("after and after...");
        return invoke;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Class<?> clazz = orderService.getClass();
        DynamicProxy proxy = new DynamicProxy(orderService);
        OrderService os = (OrderService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy);
        DynamicProxy2 proxy2 = new DynamicProxy2(os);
        OrderService os2 = (OrderService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy2);
        os2.reduceStock();
    }
    /*

    jdk动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用业务方法前调用InvocationHandler处理。
    代理类必须实现InvocationHandler接口，并且，JDK动态代理只能代理实现了接口的类，没有实现接口的类是不能实现JDK动态代理

    * 1.编写被代理的类和接口。
    * 2.编写代理类实现 InvocationHandler接口，重写invoke()方法。
    * 3.使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)动态创建代理对象，通过代理类对象调用业务方法
    * */
}
