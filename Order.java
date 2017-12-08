public class Order {

    private int orderId;
    private String status;
    private String startLocation;
    private String endLocation;
    private String carType;
    private Customer Customer;

    public Order(int orderId, Customer c, String startLocation, String endLocation, String carType){

        this.carType = carType;
        this.Customer = c;
        this.endLocation = endLocation;
        this.startLocation = startLocation;
        this.status = "Pending";
        this.orderId = orderId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getID() {
        return orderId;
    }
}
