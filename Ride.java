public class Ride {

    private int rideID;
    private double distance;
    private String status;
    private double price;
    private Person customer;
    private Person driver;

    public Ride(int id, Person customer1, Person driver1){
        this.rideID = id;
        this.distance = 0;
        this.status = "On the Way";
        this.price = 0;
        this.customer = customer1;
        this.driver = driver1;

        incrementDistance();
    }

    public double calculatePrice(double rate){
        this.price = distance* 100*rate;
        return price;
    }
    public int getID(){
        return rideID;
    }
    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        return price;
    }

    public int getRideID() {
        return rideID;
    }

    public Person getCustomer() {
        return customer;
    }

    public Person getDriver() {
        return driver;
    }

    public String getStatus() {
        return status;
    }

    private void incrementDistance(){
        /* TODO crate strategy */
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }
}
