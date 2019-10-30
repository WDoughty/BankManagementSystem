package HR;

import User.Employee;
import User.UserController;

public class Paycheck implements PaycheckInterface {
    private String employeeName, employeeNumber;
    private double hoursWorked, hourlyPay;
    private UserController employeeController;

    public Paycheck(UserController employee) {
       employeeController = employee;
       getEmployeeName();
       getEmployeeNumber();
       getHoursWorked();
       getHourlyPay();
    }

    @Override
    public void getEmployeeName() {
      employeeName = employeeController.getUserName();
    }

    @Override
    public void getEmployeeNumber() {
        employeeNumber = employeeController.getEmployeeNumber();
    }

    @Override
    public void getHoursWorked() {
        hoursWorked = employeeController.getEmployeeHoursWorked();
    }

    @Override
    public void getHourlyPay() {
        hourlyPay = employeeController.getEmployeeHourlyPay();
    }

    @Override
    public double calculatePay(double hoursWorked, double hourlyPay) {
        return hoursWorked * hourlyPay;
    }

    @Override
    public void printPayStub() {
        System.out.printf("%S %s %nHours worked: %5.2f Hourly pay: $%5.2f %n$%.2f\n", employeeName,employeeNumber,hoursWorked,hourlyPay,calculatePay(hoursWorked,hourlyPay));

    }
}
