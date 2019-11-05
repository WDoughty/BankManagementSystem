package HR;

import java.time.LocalDateTime;

public class Shift {
    private String sid;
    private String eid;
    private String start;
    private String finish;

    public void setShiftID(String s) {
        sid = s;
    }

    public void setEmployeeNumber(String e) {
        eid = e;
    }

    public void setStart(String st) {
        start = st;
    }

    public void setFinish(String f) {
        finish = f;
    }

    public String getShiftID() {
        return sid;
    }

    public String getEmployeeNumber() {
        return eid;
    }

    public String getStart() {
        return start;
    }

    public String getFinish() {
        return finish;
    }
}
