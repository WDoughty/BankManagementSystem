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
            return ((Client) model).getAccountNumber();
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
            ((Client) model).setAccountNumber(accountNumber);
        }
    }

    public void setEmployeeNumber(String employeeNumber){
        if(model instanceof Employee){
            ((Employee) model).setEmployeeNumber(employeeNumber);
        }
    }

    public String getEmployeeNumber(){
        if(model instanceof Employee){
            return ((Employee) model).getEmployeeNumber();
        }
        else{
            return "IncorrectUserException"; //Create exception class
        }
    }

    public double getEmployeeHourlyPay(){
        if(model instanceof Employee){
            return ((Employee)model).getHourlyPay();
        }
        else{
            return 0.0; //exception
        }
    }

    public double getEmployeeHoursWorked(){
        if(model instanceof Employee){
            return ((Employee) model).getHoursWorked();
        }
        else{
            return 0.0; //Exception
        }
    }

    public void setHoursWorked(double hoursWorked){
        if(model instanceof Employee){
            ((Employee) model).setHoursWorked(hoursWorked);
        }
    }

    public void setHourlyPay(double hourlyPay){
        if(model instanceof Employee){
            ((Employee) model).setHourlyPay(hourlyPay);
        }
    }

    public EmployeeTimeCardInterface getTimeCard(){
        if(model instanceof  Employee){
            return ((Employee) model).getTimeCard();
        }
        else{
        return null;
        }
    }

    public void resetHoursWorked(){
        if(model instanceof Employee){
            ((Employee) model).resetHoursWorked();
        }
    }
}
