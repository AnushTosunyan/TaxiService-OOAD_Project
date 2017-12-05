import java.util.ArrayList;
import java.util.List;

public class CarDescriptionCatalog {
    private List<CarDescription> descriptionList = new ArrayList<>();

    public CarDescription addDescription(CarDescription description) {

        for (int i=0; i<descriptionList.size(); i++ ){
            if (descriptionList.get(i) == description){
                return descriptionList.get(i);
            }
        }
        CarDescription carDescription= new CarDescription(description.getMake(), description.getModel(),
                description.getType(), description.getCapacity());
        descriptionList.add(carDescription);
        return carDescription;
    }
}
