import java.util.Scanner;

public class Driver extends Person{
    private Car car;
    private Ride ride;
    private Order order;
    private String status;

    public Driver(int id, String name, String number, Car car1){
        this.ID = id;
        this.name = name;
        this.phoneNumber = number;
        this.rating = 3;
        this.car = car1;
        this.status = "free";
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


    public void setStatus(String status) {
        this.status = status;
    }
}
