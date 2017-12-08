import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DriverCatalog {
    private List<Driver> driverList ;
    public DriverCatalog(){
        this.driverList = new ArrayList<>();
        driverList.add(new Driver(1, " ", " ", null));
        driverList.get(0).setStatus("testDriver");
    }

    public Driver createDriver( String name, String number, Car car) {
        Driver driver = new Driver((driverList.get(driverList.size() - 1).getID()+2), name, number, car);
        driverList.add(driver);
        return driver;
    }

    public Driver getDriver(int id){
        for (Driver aDriverList : driverList) {
            if (aDriverList.getID() == id) {
                return aDriverList;
            }
        }
        return null;
    }

    public Driver findDriver(String startLocation, String carType){
        double distance = 10000;
        Driver driver = driverList.get(0);
        Scanner reader = new Scanner(System.in);

        while(!reader.hasNext()) {
            while (driver == driverList.get(0)) {
                for (Driver aDriverList : driverList)
                {
                    if ((!Objects.equals(aDriverList.getStatus(), "free")) || (aDriverList.getCar().getDescription().getType() != carType)) {
                        continue;
                    }
                    if (Math.abs(Integer.parseInt(aDriverList.getCurrLocation()) - Integer.parseInt(startLocation)) < distance) {
                        distance = Math.abs(Integer.parseInt(aDriverList.getCurrLocation()) - Integer.parseInt(startLocation));
                        driver = aDriverList;
                    }

                    if (Math.abs(Integer.parseInt(aDriverList.getCurrLocation()) - Integer.parseInt(startLocation)) == distance) {
                        if (driver.getRating() < aDriverList.getRating()) {
                            driver = aDriverList;
                        }
                    }

                }
            }
            return driver;
        }
        return null;
    }
}
