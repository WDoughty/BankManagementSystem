package User;

import HR.EmployeeTimeCardInterface;

public class UserController {
    private UserInterface model;

    /**
     * Creates a new UserController
     * @param model User interface model
     */
    public UserController(UserInterface model) {
        this.model = model;
    }

    /**
     * Sets the name for the current user
     * @param name
     */
    public void setUserName(String name) {
        model.setName(name);
    }

    /**
     * Returns the name for the current user
     * @return name
     */
    public String getUserName() {
        return model.getName();
    }

    /**
     * Returns the account number of the User if the user is a Client
     * @return
     */
    public String getUserAccountNumber() {
        if (model instanceof Client) {
            return ((Client) model).getClientNumber();
        }
        else{
            return "IncorrectUserException"; // Need to create Exception class
        }
    }

    /**
     * Sets the current users account number
     * @param accountNumber
     */
    public void setUserAccountNumber(String accountNumber){
        if(model instanceof Client){
            ((Client) model).setClientNumber(accountNumber);
        }
    }

    /**
     * Sets the employee number for the current model
     * @param employeeNumber
     */
    public void setEmployeeNumber(String employeeNumber){
        if(model instanceof Employee){
            ((Employee) model).setEmployeeNumber(employeeNumber);
        }
    }

    /**
     * Gets the employee number of the current model
     * @return String
     */
    public String getEmployeeNumber(){
        if(model instanceof Employee){
            return ((Employee) model).getEmployeeNumber();
        }
        else{
            return "IncorrectUserException"; //Create exception class
        }
    }


    /**
     * Gets the hourly pay for the current model
     * @return double
     */
    public double getEmployeeHourlyPay(){
        if(model instanceof Employee){
            return ((Employee)model).getHourlyPay();
        }
        else{
            return 0.0; //exception
        }
    }

    /**
     * Gets the hours worked for the current model
     * @return double
     */
    public double getEmployeeHoursWorked(){
        if(model instanceof Employee){
            return ((Employee) model).getHoursWorked();
        }
        else{
            return 0.0; //Exception
        }
    }

    /**
     * Sets the amount of hours worked for the current model
     * @param hoursWorked
     */
    public void setHoursWorked(double hoursWorked){
        if(model instanceof Employee){
            ((Employee) model).setHoursWorked(hoursWorked);
        }
    }

    /**
     * Sets the hourly pay for the current model
     * @param hourlyPay
     */
    public void setHourlyPay(double hourlyPay){
        if(model instanceof Employee){
            ((Employee) model).setHourlyPay(hourlyPay);
        }
    }

    /**
     * Returns the current models EmployeeTimeCardInterface
     * @return EmployeeTimeCardInterface
     */
    public EmployeeTimeCardInterface getTimeCard(){
        if(model instanceof  Employee){
            return ((Employee) model).getTimeCard();
        }
        else{
        return null;
        }
    }

    /**
     * Sets the amount of hours worked for the current model to 0
     */
    public void resetHoursWorked(){
        if(model instanceof Employee){
            ((Employee) model).resetHoursWorked();
        }
    }

    public void setPassword(String password){
        model.setPassword(password);
    }

    public UserInterface getModel(){
        return model;
    }

    public String getEmail(){
        if(model instanceof Client) {
            return ((Client)model).getEmail();
        }
        return null;
    }

    public void setEmail(String email){
        if(model instanceof Client){
            ((Client)model).setEmail(email);
        }

    }

}
