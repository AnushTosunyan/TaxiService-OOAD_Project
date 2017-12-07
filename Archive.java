import java.util.*;

public class Archive {
    private List<Record> recordList;

    public Archive(){
        this.recordList = new ArrayList<>();
        recordList.add(new Record(0, 0, 0, 0.0, 0.0, null));
    }

    public Record createRecord(Ride ride){

        Record record = new Record((recordList.get(recordList.size() - 1).getID()+1), ride.getCustomer().getID(), ride.getDriver().getID(), ride.getDistance(), ride.getPrice(), new Date());
        recordList.add(record);
        return record;
    }
}
