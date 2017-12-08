public class Car {
    private String licencePlate;
    private String color;
    private CarDescription description;

    public Car(String licencePlate, String color, CarDescription desc){
        this.licencePlate = licencePlate;
        this.color = color;
        this.description = desc;
    }

    public void displayCarInfo(){
        System.out.println("The car is a " + color + " " + description.getMake() + " " + description.getModel() + " with licence plate " + licencePlate);
    }

}
