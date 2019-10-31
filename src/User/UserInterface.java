package User;


public interface UserInterface {

    /**
     * Sets the name of the current user
     * @param name
     */
    void setName(String name);

    /**
     * Returns the name of the current user
     * @return name
     */
    String getName();

    void setPassword(String password);

    String getPassword();

}
