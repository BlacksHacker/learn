package proxy.staticProxy;

public class OrderServiceProxy3 implements OrderService {
    private OrderService orderService;

    public OrderServiceProxy3(OrderService orderService) {
        this.orderService = orderService;
    }

    public void reduceStock() {
        System.out.println("拦截控制前");
        orderService.reduceStock();
        System.out.println("拦截控制后");
    }

    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        OrderService proxy = new OrderServiceProxy2(orderService);
        OrderService proxy2 = new OrderServiceProxy3(proxy);
        proxy2.reduceStock();
    }
}
