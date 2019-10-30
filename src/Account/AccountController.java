package Account;

public class AccountController implements AccountControllerInterface {

    public AccountInterface model;

    /**
     * Creates new Account Controller
     * @param model Account interface model
     */
    public AccountController(AccountInterface model){
        this.model = model;
    }

    /**
     * Requests balance from model account
     * @return balance
     */
    @Override
    public double getBalance() {
        return model.getBalance();
    }

    /**
     * Deposits amount in model account
     * @param amount
     */
    @Override
    public void deposit(double amount) {
        model.deposit(amount);
    }

    /**
     * Withdraws amount from model account if there is sufficient funds
     * @param amount
     */
    @Override
    public void withdraw(double amount) {
        model.withdraw(amount);
    }

    /**
     * Checks if there is sufficient funds for amount in the model account
     * @param amount
     * @return boolean
     */
    @Override
    public boolean isSufficientFunds(double amount) {
        return model.isSufficientFunds(amount);
    }

    @Override
    public void setInterestRate(double interestRate) {
        if(model instanceof CreditAccount){
            ((CreditAccount) model).setInterestRate(interestRate);
        }
        else if(model instanceof LoanAccount){
            ((LoanAccount) model).setInterestRate(interestRate);
        }
        else{

        }

    }
    @Override
    public double getInterestRate() {
        if(model instanceof CreditAccount){
           return  ((CreditAccount) model).getInterestRate();
        }
        else if(model instanceof LoanAccount){
           return  ((LoanAccount) model).getInterestRate();
        }
        else{
            return 0; // Exception
        }
    }

    public void deleteAccount(){ //Throw an exception for account balance!=0 or account DNE
        //Remove Account number from DB
    }


}
