package HR;

import Database.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeScheduling implements EmployeeSchedulingInterface{
    private Database db = new Database();

    public boolean addShift(String eid, LocalDateTime start, LocalDateTime finish) {
        return db.addShift(eid, start, finish);
    }

    public boolean getShifts(String eid) {
        return db.getShifts(eid);
    }
}
