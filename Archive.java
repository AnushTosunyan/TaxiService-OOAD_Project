import java.util.*;

public class Archive {
    private List<Record> recordList = new ArrayList<>();
    int records = 0;

    public Record createRecord(Ride ride){

        Record record = new Record(++records, ride.getCustomer().getID(), ride.getDriver().getID(), ride.getDistance(), ride.getPrice(), new Date());
        recordList.add(record);
        return record;
    }
}
