package User;

public class UserController {
    private UserInterface model;

    public UserController(UserInterface model) {
        this.model = model;
    }

    public void setUserName(String name) {
        model.setName(name);
    }

    public String getUserName() {
        return model.getName();
    }

    public String getUserAccountNumber() {
        if (model instanceof Client) {
            return ((Client) model).getAccountNumber();
        }
        else{
            return "IncorrectUserException"; // Need to create Exception class
        }
    }

    public void setUserAccountNumber(String accountNumber){
        if(model instanceof Client){
            ((Client) model).setAccountNumber(accountNumber);
        }
    }
}
