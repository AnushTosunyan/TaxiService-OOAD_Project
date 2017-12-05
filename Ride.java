public class Ride {

    private
        int rideID;
        double distance;
        String status;
        double price;

    public Ride(int id){
        this.rideID = id;
        this.distance = 0;
        this.status = "On the Way";
        this.price = 0;
    }
}
