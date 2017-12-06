public class Person {
    public int ID;
    public String name;
    public String phoneNumber;
    public double rating;

    public boolean cancelOrder(){return false;}

    public int getID(){return ID;}

    public void rideCanceled(){
        System.out.println("Unfortunately your ride has been canceled");
    }
}
