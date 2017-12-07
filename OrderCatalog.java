import java.util.*;

public class OrderCatalog {
    private
        List<Order> orderList;

    public OrderCatalog(){
        this.orderList = new ArrayList<>();
        orderList.add(new Order(0, null, null, null, null));
    }

    public Order makeOrder(Customer customer, String startLocation, String targetLocation, String carType){
        Order order = new Order((orderList.get(orderList.size() - 1).getID()+1), customer, startLocation, targetLocation, carType);
        orderList.add(order);
        return order;
    }

    public void delete(Order order){
            orderList.remove(order);
    }
}
