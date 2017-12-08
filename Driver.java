import java.util.Scanner;

public class Driver extends Person{
    private Car car;
    private Ride ride;
    private Order order;
    private String status;
    private String currLocation;

    public Driver(int id, String name, String number, Car car1){
        this.ID = id;
        this.name = name;
        this.phoneNumber = number;
        this.rating = 3;
        this.car = car1;
        this.status = "free";
        this.currLocation = "5";
    }

    public Car getCar() {
        return car;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setRide(Ride ride){
        this.ride = ride;
    }

    public Ride getRide(){
        return ride;
    }

    public String getStatus() {
        return status;
    }

    public void Ride(){
        Scanner reader = new Scanner(System.in);
        System.out.println("enter something to end the ride");
        while(reader.hasNext() == false){
            ride.incrementDistance();
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrLocation(String currLocation) {
        this.currLocation = currLocation;
    }

    public String getCurrLocation() {
        return currLocation;
    }
}
