package HR;

import User.Employee;

public interface EmployeeTimeCardInterface {

    void clockIn();
    void clockOut();
    double getWorkedHours();

    /**
     * this method is only for testing purposes. Times given in minutes
     * @param startTime
     * @param stopTime
     */
    void testClockInOut(int startTime,int stopTime);

}
