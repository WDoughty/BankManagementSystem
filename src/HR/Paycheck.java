package HR;

import User.Employee;
import User.UserController;

public class Paycheck implements PaycheckInterface {
    private String employeeName, employeeNumber;
    private double hoursWorked, hourlyPay;
    private UserController employeeController;

    /**
     * Creates a paycheck for a employee controller
     * @param employeeController
     */
    public Paycheck(UserController employeeController) {
       this.employeeController = employeeController;
       getEmployeeName();
       getEmployeeNumber();
       getHoursWorked();
       getHourlyPay();
    }

    /**
     * Gets the employee name
     */
    @Override
    public void getEmployeeName() {
      employeeName = employeeController.getUserName();
    }

    /**
     * Gets the employee number
     */
    @Override
    public void getEmployeeNumber() {
        employeeNumber = employeeController.getEmployeeNumber();
    }

    /**
     * Gets the hours worked by the employee
     */
    @Override
    public void getHoursWorked() {
        hoursWorked = employeeController.getEmployeeHoursWorked();
    }

    /**
     * Gets the hourly pay of an employee
     */
    @Override
    public void getHourlyPay() {
        hourlyPay = employeeController.getEmployeeHourlyPay();
    }

    /**
     * Calculates the pay for the employee
     * @param hoursWorked
     * @param hourlyPay
     * @return double
     */
    @Override
    public double calculatePay(double hoursWorked, double hourlyPay) {
        return hoursWorked * hourlyPay;
    }

    /**
     * Prints Employee information and pay information to console
     */
    @Override
    public void printPayStub() {
        System.out.printf("%S %s %nHours worked: %5.2f Hourly pay: $%5.2f %n$%.2f\n", employeeName,employeeNumber,hoursWorked,hourlyPay,calculatePay(hoursWorked,hourlyPay));

    }

    /**
     * Updates the current employees paycheck
     */
    @Override
    public void paycheckUpdate(){
        getEmployeeName();
        getEmployeeNumber();
        getHoursWorked();
        getHourlyPay();
    }
}
