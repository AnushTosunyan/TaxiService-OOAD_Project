import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class Dispatcher {
    private CarDescriptionCatalog carDescriptionCatalog;
    private OrderCatalog orderCatalog;
    private RideCatalog rideCatalog;
    private DriverCatalog driverCatalog;
    private CustomerCatalog customerCatalog;
    private CarList  carList;
    private Archive archive;
    private FeedbackCatalog feedbackCatalog;
    private List<List<Person>> listOfPairs = new ArrayList<>();


    public Dispatcher(CarList carList1, CarDescriptionCatalog carDescriptionCatalog1, FeedbackCatalog feedbackCatalog1,
                      DriverCatalog driverCatalog1,CustomerCatalog customerCatalog1,OrderCatalog orderCatalog1, RideCatalog rideCatalog1,
                      Archive archive1){
        this.carDescriptionCatalog = carDescriptionCatalog1;
        this.orderCatalog = orderCatalog1;
        this.rideCatalog = rideCatalog1;
        this.driverCatalog = driverCatalog1;
        this.customerCatalog = customerCatalog1;
        this.carList = carList1;
        this.archive = archive1;
        this.feedbackCatalog = feedbackCatalog1;
    }

    public boolean register(Information info){

        if (info.getType() == "customer") {
            Customer customer = customerCatalog.createCustomer(info.getName(), info.getPhoneNumber());
            System.out.println("your ID is " + customer.getID());
            return true;
        }
        if (isQualified(info)){
            CarDescription carDescription = carDescriptionCatalog.addDescription(info.getCarDescription());
            Car car = new Car(info.getLicencePlate(), info.getCarColor(), info.getCarDescription());
            Driver driver = driverCatalog.createDriver(info.getName(), info.getPhoneNumber(), car);

            System.out.println("your ID is "+ driver.getID());
            return true;
        }
        return  false;
    }

    public Order makeOrder(Customer customer, String startLocation, String targetLocation, String carType){
        Order order = orderCatalog.makeOrder(customer, startLocation, targetLocation, carType);
        System.out.println("Searching for appropriate drivers");
        Driver driver = findDriver(startLocation, carType);
        order.setStatus("onTheWay");
        driver.setOrder(order);
        System.out.println("Your driver is on the way");
        List<Person> pair = new ArrayList<>();
        pair.add(customer);
        pair.add(driver);
        listOfPairs.add(pair);
        return order;
    }

    private boolean isQualified(Information info){
        /* TODO create qualification strategy */
        return true;
    }

    private Driver findDriver(String startLocation, String carType){
        return driverCatalog.findDriver(startLocation, carType);
    }
}
