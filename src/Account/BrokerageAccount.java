package Account;

import Database.Database;
import User.Client;
import yahoofinance.Stock;

public class BrokerageAccount extends Account {
    private String stock;
    private int quantity;
    /**
     * Creates new account for client with account number
     *
     * @param client        New user client
     * @param accountNumber Account number assigned to this account
     */
    public BrokerageAccount(Client client, String accountNumber) {
        super(client, accountNumber);
    }

    /**
     * Returns the Stock symbol
     * @return stock
     */
    public String getStock(){
        return stock;
    }

    /**
     * Sets the stock symbol for this account
     * @param stock
     */
    public void setStock(String stock){
        this.stock = stock;
    }

    /**
     * Sets how many shares this account holds
     * @param quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Returns the quantity of shares this account holds
     * @return quantity
     */
    public int getQuantity(){
        return quantity;
    }

}
