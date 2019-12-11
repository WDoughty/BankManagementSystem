package GUI;

import Account.Account;
import Database.Database;
import User.UserController;
import User.UserInterface;
import View.View;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import Account.*;
import Exception.*;

public class Brokerage implements ActionListener {
    private JTextField stockSearchField;
    private JButton searchButton;
    private JPanel brokeragePanel;
    private JButton buyButton;
    private JLabel priceLabel;
    private JTextField quantityField;
    private JButton backButton;
    private JLabel stockNameLabel;
    private JLabel currentStock;
    private UserController user;
    private JFrame frame;
    private Database db;
    private BrokerageAccount sv;

    /**
     * Creates a new Brokerage Form
     * @param user UserController
     * @param sv Account
     */
    public Brokerage(UserController user, Account sv){
        this.sv = (BrokerageAccount) sv;
        this.user = user;
        db = new Database();
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(brokeragePanel);
        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        buyButton.addActionListener(this);
        currentStock.setText("Current Stock held: " + ((BrokerageAccount) sv).getStock() + " \n  Quantity: " + ((BrokerageAccount) sv).getQuantity());

    }

    /**
     * Button Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton && !stockSearchField.getText().isEmpty()){
            try {
                Stock stock = YahooFinance.get(stockSearchField.getText());
                BigDecimal price = stock.getQuote().getPrice();
                priceLabel.setText("$" + price);
                stockNameLabel.setText(stock.getName() + ": " + stock.getSymbol());

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == backButton){
            new accountsForm(user.getModel());
        }

        else if(e.getSource() == buyButton && !quantityField.getText().isEmpty()){
            buyStock(stockSearchField.getText(),Integer.valueOf(quantityField.getText()));



        }
    }


    /**
     * Requests user to buy stocks
     * @param stock
     * @param quantity
     */
    public void buyStock(String stock, int quantity)  {

        sv.setQuantity(quantity);
        sv.setStock(stock);
        AccountController accountController =  new AccountController(sv);
        try {
            accountController.emailUpdate(user.getEmail(), "Brokerage Account Update: " +
                    "Purchase of " + stock + ", quantity: " + quantity + " for price: " + priceLabel.getText());
        }catch(EmailNotSentException ex){
            ex.printStackTrace();
        }
        db.putBrokerageAccount(sv,user.getUserAccountNumber(),stock,quantity);


    }
}
