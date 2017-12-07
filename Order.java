public class Order {

    private
        int orderId;
        String status;
        String startLocation;
        String endLocation;
        String carType;
        Customer Customer;

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

    public int getID() {
        return orderId;
    }
}
