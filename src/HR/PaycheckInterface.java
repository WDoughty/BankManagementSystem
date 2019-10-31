package HR;

import User.Employee;

public interface PaycheckInterface {

    /**
     * Gets the employees name
     */
    void getEmployeeName();

    /**
     * Gets the employee number
     */
    void getEmployeeNumber();

    /**
     * Gets the amount of hours worked by employee
     */
    void getHoursWorked();

    /**
     * Gets the hourly pay of an employee
     */
    void getHourlyPay();

    /**
     * Calculates the pay for the employee
     * @param hoursWorked
     * @param hourlyPay
     * @return double
     */
    double calculatePay(double hoursWorked, double hourlyPay);

    /**
     * Prints Employee information and pay information to console
     */
    void printPayStub();

    /**
     * Updates the current employees paycheck
     */
    void paycheckUpdate();
}
