import java.util.Scanner;

public class Information {
    private String name;
    private String phoneNumber;
    private String type;
    private CarDescription carDescription;
    private String licencePlate;
    private String carColor;
    private int qualification;

    public Information(){
        Scanner reader = new Scanner(System.in);
        System.out.println("please enter your name");
        this.name = reader.next();

        System.out.println("please enter your phone number");
        this.phoneNumber= reader.next();


        System.out.println("please indicate if you are registering as a driver or customer");
        this.type= reader.next();


        switch (type){
            case "customer":
                this.carDescription= null;
                this.licencePlate= null;
                this.carColor= null;
                this.qualification = 10;
                break;

            case "driver":
                System.out.println("please indicate your qualification");
                this.qualification= reader.nextInt();
                System.out.println("please enter your car make");
                String make= reader.next();
                System.out.println("please enter your car model");
                String model = reader.next();
                System.out.println("please enter your car type");
                String type = reader.next();
                System.out.println("please enter your car capacity");
                int capacity = reader.nextInt();
                this.carDescription = new CarDescription( make, model, type, capacity);


                System.out.println("please enter your cars licence plate");
                this.licencePlate= reader.next();

                System.out.println("please enter your car color");
                this.carColor= reader.next();
                break;

        }
    }

    public String getCarColor() {
        return carColor;
    }

    public CarDescription getCarDescription() {
        return carDescription;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getType() {
        return type;
    }

    public int getQualification() {
        return qualification;
    }
}
