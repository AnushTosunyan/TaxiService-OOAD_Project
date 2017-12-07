import java.util.ArrayList;
import java.util.List;

public class RideCatalog {
    private
        List<Ride> rideList;
    public RideCatalog(){
        this.rideList = new ArrayList<>();
        rideList.add(new Ride(0, null, null));
    }
    public void addRide(Ride ride){
        rideList.add(ride);
    }

    public Ride newRide(Person customer, Person driver){
        Ride ride = new Ride((rideList.get(rideList.size() - 1).getID()+1), customer, driver);
        rideList.add(ride);
        return ride;
    }

    public void remove(Ride ride){
        rideList.remove(ride);
    }
}
