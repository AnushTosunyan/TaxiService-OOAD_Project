import java.util.*;

public class CustomerCatalog {

    private List<Customer> customerList ;
    public CustomerCatalog(){
        this.customerList =new ArrayList<>();
        customerList.add(new Customer(0, null, null));
    }

    public Customer createCustomer( String name, String number) {
        Customer customer = new Customer((customerList.get(customerList.size() - 1).getID()+2), name, number);
        customerList.add(customer);
        return customer;
    }

    public Customer getCustomer(int id){
        for(int i = 0; i<customerList.size(); i++){
            if(customerList.get(i).getID() == id){
                return customerList.get(i);
            }
        }
        return null;
    }
}
