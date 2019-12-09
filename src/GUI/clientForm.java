package GUI;

import Account.AccountController;
import Account.AccountControllerInterface;
import Account.AccountInterface;
import Account.CheckingAccount;
import Database.Database;
import User.Client;
import User.UserController;
import User.UserInterface;
import View.View;
import Exception.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientForm implements ActionListener {

    private JFrame frame;
    private UserController userController;
    private AccountInterface accountInterface;
    private AccountControllerInterface accountController;
    private Database db;
    private JTextField depositField;
    private JButton depositButton;
    private JTextField withdrawField;
    private JButton withdrawButton;
    private JButton logoutButton;
    private JLabel currentBalance;
    private JPanel clientPanel;

    /**
     * Creates a new Client Form
     * @param userInterface
     * @param accountInterface
     */
    public clientForm(UserInterface userInterface, AccountInterface accountInterface) {
        db = new Database();
        this.accountInterface = accountInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(clientPanel);
        userController = new UserController(userInterface);
        accountController = new AccountController(accountInterface);
        withdrawButton.addActionListener(this);
        logoutButton.addActionListener(this);
        depositButton.addActionListener(this);
        currentBalance.setText("$" + accountController.getBalance());


    }


    /**
     * Button Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "";
        if (e.getSource() == logoutButton) {
            new LoginForm();
        }
        else if (e.getSource() == withdrawButton) {
            if (!withdrawField.getText().isEmpty() && verifyInput(withdrawField.getText())) {
                accountController.withdraw(Double.parseDouble(withdrawField.getText()));
                db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                db.putTransacation(userController.getUserAccountNumber(), ((CheckingAccount) accountController.getAccount()).getAccountNumber(), "withdrawal", Double.parseDouble(withdrawField.getText()));
                System.out.println("Withdraws: $" + withdrawField.getText());
                System.out.println("$" + accountController.getBalance());
                currentBalance.setText("$" + accountController.getBalance());

                message = "Withdraw of $" +withdrawField.getText() + " from account: " + userController.getUserAccountNumber();
                updateEmail(message);
            }
            frame.getContentPane().repaint();
            }
        else if (e.getSource() == depositButton) {
            if (!depositField.getText().isEmpty() && verifyInput(depositField.getText())) {
                accountController.deposit(Double.parseDouble(depositField.getText()));
                db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                db.putTransacation(userController.getUserAccountNumber(), ((CheckingAccount) accountController.getAccount()).getAccountNumber(), "deposit", Double.parseDouble(depositField.getText()));
                System.out.println("Deposits: $" + depositField.getText());
                System.out.println("$" + accountController.getBalance());
                currentBalance.setText("$" + accountController.getBalance());

                message = "Deposit of $" +depositField.getText() + " into account: " +userController.getUserAccountNumber();
                updateEmail(message);

            }

            frame.getContentPane().repaint();
        }


    }

    /**
     * Makes sure user input is correct
     * @param s
     * @return
     */
    public boolean verifyInput(String s){
        return Double.parseDouble(s) >0;

    }

    /**
     * Sends an email update
     * @param message
     */
    public void updateEmail(String message){
        try {
            accountController.emailUpdate(userController.getEmail(), message);
        }catch(EmailNotSentException ex){
            ex.printStackTrace();
        }

    }

}
