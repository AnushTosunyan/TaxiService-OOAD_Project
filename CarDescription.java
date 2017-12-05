public class CarDescription {

    private String model;
    private String make;
    private String type;
    private int capacity;

    public CarDescription(String make, String model, String type, int capacity){
        this.model = model;
        this.make = make;
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }
}
