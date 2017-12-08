import java.util.ArrayList;
import java.util.List;
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
        for(int i = 0; i<driverList.size(); i++){
            if(driverList.get(i).getID() == id){
                return driverList.get(i);
            }
        }
        return null;
    }

    public Driver findDriver(String startLocation, String carType){
        double distance = 10000;
        Driver driver = driverList.get(0);
        Scanner reader = new Scanner(System.in);

        while(reader.hasNext() == false) {
            while (driver == driverList.get(0)) {
                for (int i = 0; i < driverList.size(); i++) {
                    if (driverList.get(i).getStatus() == "free" && driverList.get(i).getCar().getDescription().getType() == carType) {
                        if (Math.abs(Integer.parseInt(driverList.get(i).getCurrLocation()) - Integer.parseInt(startLocation)) < distance) {
                            distance = Math.abs(Integer.parseInt(driverList.get(i).getCurrLocation()) - Integer.parseInt(startLocation));
                            driver = driverList.get(i);
                        }

                        if (Math.abs(Integer.parseInt(driverList.get(i).getCurrLocation()) - Integer.parseInt(startLocation)) == distance) {
                            if (driver.getRating() < driverList.get(i).getRating()) {
                                driver = driverList.get(i);
                            }
                        }

                    }
                }
            }
        }
        return driver;
    }
}
