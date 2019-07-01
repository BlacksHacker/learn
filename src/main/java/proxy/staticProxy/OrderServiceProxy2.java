package proxy.staticProxy;

public class OrderServiceProxy2 implements OrderService {

    private OrderService orderService;

    public OrderServiceProxy2(OrderService orderService) {
        this.orderService = orderService;
    }

    public void reduceStock() {
        System.out.println("前置处理");
        orderService.reduceStock();
        System.out.println("后置处理");
    }

    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        OrderServiceProxy2 proxy2 = new OrderServiceProxy2(orderService);
        proxy2.reduceStock();
    }
}
