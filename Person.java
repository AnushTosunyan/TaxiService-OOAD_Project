import java.util.Scanner;

public class Person {
    public int ID;
    public String name;
    public String phoneNumber;
    public double rating;
    public Dispatcher dispatcher;
    public Order order;

    public Order getOrder() {
        return order;
    }

    public boolean cancelOrder(){return false;}

    public int getID(){return ID;}

    public void rideCanceled(){
        System.out.println("Unfortunately your ride has been canceled");
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void notifyForFeedback(Person person){

        Scanner reader = new Scanner(System.in);


        System.out.println("Would you like to rate your ride? Please enter 'yes' or 'no' ");
        String res = " ";
        while(!res.equals("no")) {
            res = reader.next();
            if (res.equals("yes")) {

                System.out.println("Please rate your ride on a scale from 1 to 5");
                double rating = reader.nextDouble();
                while(rating >5 || rating <1){
                    System.out.println("Please rate your ride on a scale from 1 to 5");
                    rating = reader.nextDouble();
                }
                System.out.println("Please add an additional comment");
                String comment = reader.next();

                dispatcher.leaveFeedback(comment, rating, person);
            }
        }
    }
}
