package proxy.staticProxy;

public class OrderServiceLogProxy extends OrderServiceImpl {
    @Override
    public void reduceStock(){
        System.out.println("前置处理");
        super.reduceStock();
        System.out.println("后置处理");
    }

    public static void main(String[] args) {
        OrderServiceLogProxy orderServiceLogProxy = new OrderServiceLogProxy();
        orderServiceLogProxy.reduceStock();
    }
}
