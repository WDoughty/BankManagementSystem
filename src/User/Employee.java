package User;

public class Employee implements UserInterface {
    public String name;
    private String employeeNumber;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
