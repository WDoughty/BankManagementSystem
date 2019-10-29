package User;

public class Employee implements UserInterface {
    public String name;
    private String employeeNumber;
    private float hoursWorked;
    private float hourlyPay;

    /**
     * Sets the name of the current user
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
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

    public float getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked){
        this.hoursWorked += hoursWorked;
    }

    public void resetHoursWorked(){
        hoursWorked = 0;
    }

    public float getHourlyPay(){
        return hourlyPay;
    }

    public void setHourlyPay(float hourlyPay){
        this.hourlyPay = hourlyPay;
    }


}
