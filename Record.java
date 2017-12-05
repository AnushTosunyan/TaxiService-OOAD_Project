import java.util.Date;

public class Record {
    private int recordID;
    private int customerID;
    private int driverID;
    private double distance;
    private double price;
    private Date date;

    public Record(int recordID, int customerID, int driverID, double distance, double price, Date date){
        this.recordID = recordID;
        this.customerID = customerID;
        this.driverID = driverID;
        this.distance = distance;
        this.price = price;
        this.date = date;
    }
}
