package proxy.dynamicJdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class HashMapProxyTest {
    public static void main(String[] args) {
        final HashMap<String, Object> hashMap = new HashMap();
        Map<String, Object> mapProxy = (Map<String, Object>)Proxy.newProxyInstance(HashMap.class.getClassLoader(), HashMap.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("handler.....");
                return method.invoke(hashMap, args);
            }
        });
        mapProxy.put("key1", "value2");
        System.out.println(mapProxy);
    }
}
