import java.util.ArrayList;
import java.util.List;

public class DriverCatalog {
    private List<Driver> driverList ;
    public DriverCatalog(){
        this.driverList = new ArrayList<>();
        driverList.add(new Driver(1, " ", " ", null));
    }

    public Driver createDriver( String name, String number, Car car) {
        Driver driver = new Driver((driverList.get(driverList.size() - 1).getID()+2), name, number, car);
        driverList.add(driver);
        return driver;
    }

    public Driver getDriver(int id){
        for(int i = 0; i<driverList.size(); i++){
            if(driverList.get(i).getID() == id){
                return driverList.get(i);
            }
        }
        return null;
    }

    public Driver findDriver(String startLocation, String carType){
        /* TODO search for appropriate drivers */
        return driverList.get(driverList.size()-1);
    }
}
