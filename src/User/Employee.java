package User;

import HR.EmployeeTimeCard;
import HR.EmployeeTimeCardInterface;

public class Employee implements UserInterface {
    public String name;
    private String employeeNumber;
    private String password;
    private double hoursWorked;
    private double hourlyPay;
    private EmployeeTimeCardInterface timeCard;

    public Employee(){
        timeCard = new EmployeeTimeCard();
    }

    /**
     * Sets the name of the current user
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    /**
    * Sets the password for the user.
    * @param password
    */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    
    /** 
    * Returns the password of the current user.
     * @return 
    * @return password
    */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Returns the name of the current user
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the employee number
     * @param employeeNumber
     */
    public void setEmployeeNumber(String employeeNumber){
        this.employeeNumber = employeeNumber;
    }

    /**
     * Returns the employee's employee number as a string
     * @return employeeNumber
     */
    public String getEmployeeNumber(){
        return employeeNumber;
    }

    /**
     * Gets the hours worked for the employee
     * @return double
     */
    public double getHoursWorked(){
        return hoursWorked;
    }

    /**
     * Adds the amount of hours worked to the total
     * @param hoursWorked
     */
    public void setHoursWorked(double hoursWorked){
        this.hoursWorked += hoursWorked;
    }

    /**
     * Sets the amount of hours worked to 0
     */
    public void resetHoursWorked(){
        hoursWorked = 0;
    }

    /**
     * Returns the hourly pay of the employee
     * @return double
     */
    public double getHourlyPay(){
        return hourlyPay;
    }

    /**
     * Sets the hourly pay of the employee
     * @param hourlyPay
     */
    public void setHourlyPay(double hourlyPay){
        this.hourlyPay = hourlyPay;
    }

    /**
     * Returns the employees time card
     * @return EmployeeTimeCardInterface
     */
    public EmployeeTimeCardInterface getTimeCard(){
        return timeCard;
    }

}
