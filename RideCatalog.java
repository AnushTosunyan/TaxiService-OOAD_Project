import java.util.ArrayList;
import java.util.List;

public class RideCatalog {
    private
        List<Ride> rideList = new ArrayList<>();
        int rides = 0;

    public void addRide(Ride ride){
        rideList.add(ride);
    }

    public Ride newRide(){
        Ride ride = new Ride(++rides);
        rideList.add(ride);
        return ride;
    }
}
