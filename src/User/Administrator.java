package User;

public class Administrator implements UserInterface {
    private String name;
    private String password;

    /**
     * Sets the name of the Administrator
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the Adminstrator
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Sets the password for the administrator
     * @param password
     */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}

    /**
     * Returns the password of the administrator
     * @return String
     */
	@Override
	public String getPassword() {
		return password;
	}

}
