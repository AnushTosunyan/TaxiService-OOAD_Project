import java.util.ArrayList;
import java.util.List;

public class RideCatalog {
    private
        List<Ride> rideList = new ArrayList<>();
        int rides = 0;

    public void addRide(Ride ride){
        rideList.add(ride);
    }

    public Ride newRide(Person customer, Person driver){
        Ride ride = new Ride(++rides, customer, driver);
        rideList.add(ride);
        return ride;
    }

    public void remove(Ride ride){
        rideList.remove(ride);
    }
}
