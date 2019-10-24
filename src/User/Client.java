package User;

public class Client implements UserInterface {
    private String accountNumber;
    private String name;

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getName() {
        return this.name;
    }
}

