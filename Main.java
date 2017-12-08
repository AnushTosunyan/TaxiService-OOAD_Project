import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg){

        TaxiService taxiService = new TaxiService("asdg", "askfh", 36455, "ajkdha");
        Dispatcher dispatcher= taxiService.getDispatcher();

        String input = "";
        Scanner reader = new Scanner(System.in);
        dispatcher.leaveFeedback("asdasd", 3.5, dispatcher.getCustomerCatalog().getCustomer(0));
        while(input != "exit"){
            input = reader.next();
            int currentID;
            Customer customer;
            Driver driver;
            switch (input){
                case "register":
                    reader.nextLine();
                    Information currentInfo = new Information();
                    dispatcher.register(currentInfo);
                    break;
                case "makeOrder":
                    reader.nextLine();
                    System.out.println("Please enter your ID");
                    currentID = reader.nextInt();
                    customer = dispatcher.getCustomerCatalog().getCustomer(currentID);
                    System.out.println("Please enter your Start location");
                    String startLocation = reader.next();
                    System.out.println("Please enter your End location");
                    String endLocation = reader.next();
                    System.out.println("Please enter the car type");
                    String carType = reader.next();
                    dispatcher.makeOrder(customer, startLocation, endLocation, carType);
                    break;
                case "cancelOrder":
                    reader.nextLine();
                    System.out.println("Please enter your ID");
                    currentID = reader.nextInt();
                    if(currentID%2 == 0) {
                        customer = dispatcher.getCustomerCatalog().getCustomer(currentID);
                        dispatcher.cancelOrder(customer);
                    }
                    else
                    {
                        driver = dispatcher.getDriverCatalog().getDriver(currentID);
                        dispatcher.cancelOrder(driver);
                    }
                    break;
                case "startRide":
                    reader.nextLine();
                    System.out.println("Please enter your ID");
                    currentID = reader.nextInt();
                    driver = dispatcher.getDriverCatalog().getDriver(currentID);
                    dispatcher.startRide(driver);
            }
        }
    }
}
