import java.util.*;

public class Archive {
    private List<Record> recordList = new ArrayList<>();
    int records = 0;

    public Record createRecord( int customerID, int driverID, double distance, double price, Date date){
        Record record = new Record(++records, customerID,driverID, distance, price, date);
        recordList.add(record);
        return record;
    }
}
