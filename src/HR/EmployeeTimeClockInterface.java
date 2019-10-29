package HR;

import User.Employee;

public interface EmployeeTimeClockInterface {

    void clockIn();
    void clockOut();
    double getWorkedHours();

}
