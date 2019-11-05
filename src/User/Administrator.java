package User;

public class Administrator implements UserInterface {
    private String name;
    private String password;
    private String number;

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

    /**
     * Sets the User Number of the Administrator
     * @param adminNumber
     */
    public void setAdminNumber(String adminNumber) {
        this.number = adminNumber;
    }

    /**
     * Returns the User Number of the Adminstrator
     * @return String
     */
    public String getAdminNumber() {
        return number;
    }


}
