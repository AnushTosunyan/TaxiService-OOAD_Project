import java.util.*;

public class OrderCatalog {
    private
        List<Order> orderList = new ArrayList<>();
        int orders = 0;

    public Order makeOrder(Customer customer, String startLocation, String targetLocation, String carType){
        Order order = new Order(++orders, customer, startLocation, targetLocation, carType);
        orderList.add(order);
        return order;
    }

    public void delete(Order order){
            orderList.remove(order);
    }
}
