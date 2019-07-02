package proxy.dynamicJdk;

import proxy.staticProxy.OrderService;
import proxy.staticProxy.OrderServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before.....");
        Object invoke = method.invoke(target, args);
        System.out.println("after...");
        return invoke;
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        Class<?> clazz = orderService.getClass();
        DynamicProxy proxy = new DynamicProxy(orderService);
        OrderService os = (OrderService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy);
        os.reduceStock();
    }
    /*
    * 1.编写被代理的类和接口。
    * 2.编写代理类实现 InvocationHandler接口，重写invoke()方法。
    * 3.使用Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)动态创建代理对象，通过代理类对象调用业务方法
    *
    * JDK动态代理只能代理实现了接口的类，没有实现接口的类不能实现JDK的动态代理
    * */
}
