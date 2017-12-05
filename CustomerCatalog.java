import java.util.*;

public class CustomerCatalog {

    private List<Customer> orderList = new ArrayList<>();
    private int customers = 0;

    public Customer createCustomer( String name, String number) {
        Customer customer = new Customer(++customers, name, number);
        orderList.add(customer);
        return customer;
    }
}
