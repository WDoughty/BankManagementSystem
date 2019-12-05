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

    public String getStock(){
        return stock;
    }

    public void setStock(String stock){
        this.stock = stock;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

}
