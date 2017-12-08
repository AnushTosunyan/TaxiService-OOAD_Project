import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] arg){

        TaxiService taxiService = new TaxiService("asdg", "askfh", 36455, "ajkdha");
        Dispatcher dispatcher= taxiService.getDispatcher();


        ArrayList<String> intro = check("Intro");
        printIntro(0, intro);

        String input = "";
        Scanner reader = new Scanner(System.in);

        while(!input.equals("exit")){
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
        reader.close();
    }
    public static void printIntro(int count, ArrayList<String> intro) {
        for (;count < intro.size(); count++) {
            System.out.println(intro.get(count));
        }
    }

    private static ArrayList<String> check(String fileName){
        ArrayList<String> intro = new ArrayList<>();
        String line;
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                intro.add(line);
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
            return null;
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            return null;
        }

        return intro;
    }
}
