package proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import proxy.staticProxy.OrderServiceImpl;

import java.lang.reflect.Method;

/*
* Cglib动态代理基于类实现代理的，运行时动态生成被代理类的子类拦截父类方法调用，因此不能代理声明为final类型的类和方法
* */
public class DynamicCglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxyObj(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        enhancer.setUseCache(false);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("123.....");
        methodProxy.invokeSuper(o, objects);
        System.out.println("456....");
        return null;
    }

    public static void main(String[] args) {
        DynamicCglibProxy proxy = new DynamicCglibProxy();
        OrderServiceImpl orderService = (OrderServiceImpl) proxy.getProxyObj(OrderServiceImpl.class);
        orderService.reduceStock();
    }
}
