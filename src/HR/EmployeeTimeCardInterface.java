package HR;

import User.Employee;

public interface EmployeeTimeCardInterface {

    void clockIn();
    void clockOut();
    double getWorkedHours();
    void testClockInOut();

}
