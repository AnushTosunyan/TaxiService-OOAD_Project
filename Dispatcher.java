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
        return info.getQualification() > 6;
    }


    private void updateRating(Person person, Feedback feedback) {

        double currRaring = person.getRating();
        double change = feedback.getRating();

        person.setRating(currRaring + (currRaring - change)/10);
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
            customer.setDispatcher(this);

            System.out.println("your ID is " + customer.getID());
            return true;
        }
        else if (isQualified(info)){
            CarDescription carDescription = carDescriptionCatalog.addDescription(info.getCarDescription());
            Car car = carList.newCar(info.getLicencePlate(), info.getCarColor(), carDescription);

            Driver driver = driverCatalog.createDriver(info.getName(), info.getPhoneNumber(), car);
            driver.setDispatcher(this);

            System.out.println("your ID is "+ driver.getID());
            return true;
        }
        System.out.println("Unfortunately you are not qualified to work in this Taxi service");
        return  false;

    }


    public Order makeOrder(Customer customer, String startLocation, String targetLocation, String carType){
        Order order = orderCatalog.makeOrder(customer, startLocation, targetLocation, carType);
        System.out.println("Searching for appropriate drivers");
        Driver driver = driverCatalog.findDriver(startLocation, carType);

        if (driver == null) {
            System.out.println("The order has been canceled");
            return null;
        }

        order.setStatus("onTheWay");
        driver.setOrder(order);
        System.out.println("Your driver is on the way");
        driver.getCar().displayCarInfo();
        List<Person> pair = new ArrayList<>();
        pair.add(customer);
        pair.add(driver);
        listOfPairs.add(pair);
        return order;
    }

    public boolean cancelOrder(Person person){
        if(person.getOrder() == null){
            System.out.println("You do not have an order to cancel");
            return false;
        }
        Feedback feedback = feedbackCatalog.createFeedback(2.0, " ", person.getID());
        updateRating(person, feedback);
        for(int i=0; i< listOfPairs.size(); i++){
            if(listOfPairs.get(i).get(0) == person){
                listOfPairs.get(i).get(1).rideCanceled();
                listOfPairs.remove(listOfPairs.get(i));
                System.out.println("Your Order has been successfully canceled");
                return true;
            }
            if(listOfPairs.get(i).get(1) == person){
                listOfPairs.get(i).get(0).rideCanceled();
                listOfPairs.remove(listOfPairs.get(i));
                System.out.println("Your Order has been successfully canceled");
                return true;
            }
        }
        return false;
    }

    public void startRide(Driver driver){
        for (List<Person> listOfPair : listOfPairs) {
            if (listOfPair.get(1) == driver) {
                Person customer = listOfPair.get(0);
                Ride ride = rideCatalog.newRide(driver, customer);
                driver.setRide(ride);
                ride.setCustomer(customer);
                ride.setDriver(driver);
                driver.setStatus("free");
                Order order = driver.getOrder();
                order.setStatus("Completed");
                orderCatalog.delete(order);
            }
        }

        System.out.println("Your ride has started");

        driver.Ride();

        System.out.println("Your ride has ended");
        finishRide(driver);

    }

    public double finishRide(Driver driver){
        Ride ride = driver.getRide();
        double rate = taxiService.getRate();
        archive.createRecord(ride);
        double price = ride.calculatePrice(rate);

        driver.notifyForFeedback(ride.getCustomer());
        ride.getCustomer().notifyForFeedback(driver);

        System.out.println(price);
        rideCatalog.remove(ride);
        return price;
    }

    public void leaveFeedback(String text, double rating, Person person){

        Feedback feedback = feedbackCatalog.createFeedback(rating, text, person.getID());
        updateRating(person, feedback);
    }
}
