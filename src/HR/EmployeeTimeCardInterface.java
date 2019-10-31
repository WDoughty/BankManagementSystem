package HR;

import User.Employee;

public interface EmployeeTimeCardInterface {

    /**
     * Clocks the employee in at the current time
     */
    void clockIn();

    /**
     * Clocks the employee out at the current time
     */
    void clockOut();

    /**
     * Returns the hours worked
     * @return double
     */
    double getWorkedHours();

    /**
     * this method is only for testing purposes. Times given in minutes
     * @param startTime
     * @param stopTime
     */
    void testClockInOut(int startTime,int stopTime);

}
