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

    public double getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked){
        this.hoursWorked += hoursWorked;
    }

    public void resetHoursWorked(){
        hoursWorked = 0;
    }

    public double getHourlyPay(){
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay){
        this.hourlyPay = hourlyPay;
    }

    public EmployeeTimeCardInterface getTimeCard(){
        return timeCard;
    }

}
