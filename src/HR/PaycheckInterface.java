package HR;

import User.Employee;

public interface PaycheckInterface {

    void getEmployeeName();
    void getEmployeeNumber();
    void getHoursWorked();
    void getHourlyPay();
    double calculatePay(double hoursWorked, double hourlyPay);
    void printPayStub();
    void paycheckUpdate();
}
