import java.util.*;
public class CarList {

    private List<Car> carList = new ArrayList<>();

    public Car newCar(String licencePlate,String  carColor,CarDescription carDescription) {
        Car car = new Car(licencePlate, carColor, carDescription);
        carList.add(car);
        return car;
    }
}
