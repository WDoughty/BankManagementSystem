package User;

public class Client implements UserInterface {
    private String accountNumber;
    private String name;
    private String password;

    /**
     * Sets the name of the current user
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the current user
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the account number for the Client
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Returns the account number of the Client
     * @return accountNumber
     */
    public String getAccountNumber(){
        return accountNumber;
    }

    /**
     * Sets the new password for the Client
     * @param password
     */
	@Override
	public void setPassword(String password) {
		this.password = password;
		
	}
	
	/**
	 *  Returns the password for the Client
	 *  @return password
	 */
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
}

