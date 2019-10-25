package Account;

public class AccountController implements AccountControlllerInterface {

    public AccountInterface model;

    public AccountController(AccountInterface model){
        this.model = model;
    }

    @Override
    public int getBalance() {
        return model.getBalance();
    }

    @Override
    public void deposit(int amount) {
        model.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        model.withdraw(amount);
    }

    @Override
    public boolean isSufficientFunds(int amount) {
        return model.isSufficientFunds(amount);
    }
}
