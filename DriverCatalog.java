import java.util.ArrayList;
import java.util.List;

public class DriverCatalog {
    private List<Driver> driverList = new ArrayList<>();
    private int drivers = 0;

    public Driver createDriver( String name, String number, Car car) {
        Driver driver = new Driver(2*(++drivers + 1), name, number, car);
        driverList.add(driver);
        return driver;
    }

    public Driver findDriver(String startLocation, String carType){
        /* TODO search for appropriate drivers */
        return driverList.get(0);
    }
}
