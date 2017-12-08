import java.util.ArrayList;
import java.util.List;

public class CarDescriptionCatalog {
    private List<CarDescription> descriptionList = new ArrayList<>();


    public CarDescription addDescription(CarDescription description) {

        for (CarDescription desc: descriptionList){
            if (desc == description) return desc;
        }
        CarDescription carDescription= new CarDescription(description.getMake(), description.getModel(),
                description.getType(), description.getCapacity());
        descriptionList.add(carDescription);
        return carDescription;
    }
}
