import java.net.MalformedURLException;
import java.net.URL;

public class TaxiService {
    private String name;
    private String address;
    private int phone;
    private String webpage;
    private CarDescriptionCatalog carDescriptionCatalog;
    private OrderCatalog orderCatalog;
    private RideCatalog rideCatalog;
    private DriverCatalog driverCatalog;
    private CustomerCatalog customerCatalog;
    private CarList  carList;
    private Archive archive;
    private FeedbackCatalog feedbackCatalog;
    private Dispatcher dispatcher;
    private double rate = 1.0;

    public TaxiService(String n, String a, int number, String web){
        this.name = n;
        this.address = a;
        this.phone = number;
        this.webpage = web;
//        try {
//            this.webpage = new URL(web);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        this.carDescriptionCatalog = new CarDescriptionCatalog();
        this.orderCatalog = new OrderCatalog();
        this.rideCatalog = new RideCatalog();
        this.driverCatalog = new DriverCatalog();
        this.customerCatalog = new CustomerCatalog();
        this.carList = new CarList();
        this.archive = new Archive();
        this.feedbackCatalog = new FeedbackCatalog();
        this.dispatcher = new Dispatcher(this,carList, carDescriptionCatalog, feedbackCatalog, driverCatalog, customerCatalog,
                orderCatalog, rideCatalog, archive);
    }

    public double getRate(){
        return rate;
    }

    public void setRate(double rate){
        this.rate = rate;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }
}
