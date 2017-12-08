public class Customer extends Person{
    private Order order;


    public Customer(int id, String name, String number){
        this.ID = id;
        this.name = name;
        this.phoneNumber = number;
        this.rating = 3;
    }

    public Order getOrder() {
        return order;
    }
}
