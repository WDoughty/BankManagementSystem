package HR;

import User.Employee;

public interface PaycheckInterface {

    void getEmployee();
    void getHoursWorked();
    void getHourlyPay();
    float calculatePay(float hoursWorked, float hourlyPay);
    void printPayStub();
}
