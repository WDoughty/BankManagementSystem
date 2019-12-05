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

public class Brokerage implements ActionListener {
    private JTextField stockSearchField;
    private JButton searchButton;
    private JPanel brokeragePanel;
    private JButton buyButton;
    private JLabel priceLabel;
    private JTextField quantityField;
    private JButton backButton;
    private UserController user;
    private JFrame frame;
    private Database db;
    private BrokerageAccount sv;

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchButton && !stockSearchField.getText().isEmpty()){
            try {
                Stock stock = YahooFinance.get(stockSearchField.getText());
                BigDecimal price = stock.getQuote().getPrice();
                priceLabel.setText("$" + price);

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


    public void buyStock(String stock, int quantity){

        sv.setQuantity(quantity);
        sv.setStock(stock);
        AccountController accountController =  new AccountController(sv);
        accountController.emailUpdate(user.getEmail(),"Brokerage Account Update: " +
                "Purchase of " + stock +", quantity: " + quantity + " for price: " + priceLabel.getText());
        db.putBrokerageAccount(sv,user.getUserAccountNumber(),stock,quantity);


    }
}
