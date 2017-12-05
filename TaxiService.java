import java.net.URL;

public class TaxiService {
    private String name;
    private String address;
    private int phone;
    private URL webpage;
    private CarDescriptionCatalog carDescriptionCatalog;
    private OrderCatalog orderCatalog;
    private RideCatalog rideCatalog;
    private DriverCatalog driverCatalog;
    private CustomerCatalog customerCatalog;
    private CarList  carList;
    private Archive archive;
    private FeedbackCatalog feedbackCatalog;
    private Dispatcher dispatcher;

    public TaxiService(String n, String a, int number, URL web){
        this.name = n;
        this.address = a;
        this.phone = number;
        this.webpage = web;
        this.carDescriptionCatalog = new CarDescriptionCatalog();
        this.orderCatalog = new OrderCatalog();
        this.rideCatalog = new RideCatalog();
        this.driverCatalog = new DriverCatalog();
        this.customerCatalog = new CustomerCatalog();
        this.carList = new CarList();
        this.archive = new Archive();
        this.feedbackCatalog = new FeedbackCatalog();
        this.dispatcher = new Dispatcher(carList, carDescriptionCatalog, feedbackCatalog, driverCatalog, customerCatalog,
                orderCatalog, rideCatalog, archive);
    }
}
