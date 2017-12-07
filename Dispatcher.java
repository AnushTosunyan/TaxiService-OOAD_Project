import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class Dispatcher {
    private TaxiService taxiService;
    private CarDescriptionCatalog carDescriptionCatalog;
    private OrderCatalog orderCatalog;
    private RideCatalog rideCatalog;
    private DriverCatalog driverCatalog;
    private CustomerCatalog customerCatalog;
    private CarList  carList;
    private Archive archive;
    private FeedbackCatalog feedbackCatalog;
    private List<List<Person>> listOfPairs = new ArrayList<>();


    public Dispatcher(TaxiService taxiService, CarList carList1, CarDescriptionCatalog carDescriptionCatalog1, FeedbackCatalog feedbackCatalog1,
                      DriverCatalog driverCatalog1,CustomerCatalog customerCatalog1,OrderCatalog orderCatalog1, RideCatalog rideCatalog1,
                      Archive archive1){

        this.taxiService = taxiService;
        this.carDescriptionCatalog = carDescriptionCatalog1;
        this.orderCatalog = orderCatalog1;
        this.rideCatalog = rideCatalog1;
        this.driverCatalog = driverCatalog1;
        this.customerCatalog = customerCatalog1;
        this.carList = carList1;
        this.archive = archive1;
        this.feedbackCatalog = feedbackCatalog1;
    }
    private boolean isQualified(Information info){
        /* TODO create qualification strategy */
        return true;
    }


    private void updateRating(Person person, Feedback feedback) {
        /* TODO create rating strategy */
    }

    public CustomerCatalog getCustomerCatalog() {
        return customerCatalog;
    }

    public DriverCatalog getDriverCatalog() {
        return driverCatalog;
    }

    public boolean register(Information info){

        if (info.getType().equals("customer")) {
            Customer customer = customerCatalog.createCustomer(info.getName(), info.getPhoneNumber());
            System.out.println("your ID is " + customer.getID());
            return true;
        }
        else if (isQualified(info)){
            CarDescription carDescription = carDescriptionCatalog.addDescription(info.getCarDescription());
            Car car = new Car(info.getLicencePlate(), info.getCarColor(), carDescription);
            carList.addCar(car);

            Driver driver = driverCatalog.createDriver(info.getName(), info.getPhoneNumber(), car);

            System.out.println("your ID is "+ driver.getID());
            return true;
        }
        return  false;

    }


    public Order makeOrder(Customer customer, String startLocation, String targetLocation, String carType){
        Order order = orderCatalog.makeOrder(customer, startLocation, targetLocation, carType);
        System.out.println("Searching for appropriate drivers");
        Driver driver = driverCatalog.findDriver(startLocation, carType);
        order.setStatus("onTheWay");
        driver.setOrder(order);
        System.out.println("Your driver is on the way");
        List<Person> pair = new ArrayList<>();
        pair.add(customer);
        pair.add(driver);
        listOfPairs.add(pair);
        return order;
    }

    public boolean cancelOrder(Person person){
        updateRating(person, null);
        for(int i=0; i< listOfPairs.size(); i++){
            if(listOfPairs.get(i).get(0) == person){
                listOfPairs.get(i).get(1).rideCanceled();
                listOfPairs.remove(i);
                System.out.println("Your Order has been successfully canceled");
                return true;
            }
            if(listOfPairs.get(i).get(1) == person){
                listOfPairs.get(i).get(0).rideCanceled();
                listOfPairs.remove(i);
                System.out.println("Your Order has been successfully canceled");
                return true;
            }
        }
        return false;
    }

    public void startRide(Driver driver){
        for(int i=0; i< listOfPairs.size(); i++) {
            if(listOfPairs.get(i).get(1) == driver){
                Person customer = listOfPairs.get(i).get(0);
                Ride ride = rideCatalog.newRide(driver, customer);
                driver.setRide(ride);
                ride.setCustomer(customer);
                ride.setDriver(driver);

                Order order = driver.getOrder();
                orderCatalog.delete(order);
            }
        }

        System.out.println("Your ride has started");

        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        reader.next();

        System.out.println("Your ride has ended");
        finishRide(driver);

    }

    public double finishRide(Driver driver){
        Ride ride = driver.getRide();
        double rate = taxiService.getRate();
        archive.createRecord(ride);
        double price = ride.calculatePrice(rate);

        System.out.println("Please enter your ID");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();

        System.out.println("Please rate your ride on a scale from 1 to 5");
        double rating = reader.nextDouble();
        int currID = reader.nextInt();

        System.out.println("Please add an additional comment");
        String comment= reader.next();

        if(currID == driver.getID()){
            leaveFeedback(comment, rating, ride.getCustomer());
        }
        else {
            leaveFeedback(comment, rating, driver);
        }
        rideCatalog.remove(ride);
        return price;
    }

    public void leaveFeedback(String text, double rating, Person person){

        Feedback feedback = feedbackCatalog.createFeedback(rating, text, person.getID());
        updateRating(person, feedback);
    }
}
