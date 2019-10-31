package HR;

import Database.Database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeScheduling implements EmployeeSchedulingInterface{
    private Database db = new Database();

    public void addShift(String eid, LocalDateTime start, LocalDateTime finish) {
        db.addShift(eid, start, finish);
    }

    public void getShifts(String eid) {
        db.getShifts(eid);
    }
}
