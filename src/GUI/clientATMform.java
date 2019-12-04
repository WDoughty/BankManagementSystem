package GUI;

import ATM.ATM;
import Account.AccountController;
import Account.CheckingAccount;
import Account.AccountInterface;
import Database.Database;
import User.UserController;
import User.UserInterface;
import Account.AccountControllerInterface;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientATMform implements ActionListener
{
    private JFrame frame;
    private UserInterface userInterface;
    private AccountInterface accountInterface;
    private UserController userController;
    private AccountControllerInterface accountController;
    private JPanel clientATMform;
    private JTextField DepositText;
    private JTextField WithdrawalText;
    private JTextField StampsText;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton buyStampsButton;
    private JButton logOutButton;
    private JLabel currentBalance;
    private Database db;

    public clientATMform(UserInterface userInterface, AccountInterface accountInterface)
    {
        this.userInterface = userInterface;
        this.accountInterface = accountInterface;
        userController = new UserController(userInterface);
        accountController = new AccountController(this.accountInterface);
        frame = ATM.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(clientATMform);
        frame.revalidate();
        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
        db = new Database();
        currentBalance.setText("$" + accountController.getBalance());
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        buyStampsButton.addActionListener(this);
        logOutButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == depositButton)
        {
            if(!DepositText.getText().isEmpty() && Double.parseDouble(DepositText.getText()) > 0)
            {
                if(accountController.getAccount() instanceof CheckingAccount) {
                    accountController.deposit(Double.parseDouble(DepositText.getText()));
                    db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                    db.putTransacation(userController.getUserAccountNumber(), ((CheckingAccount) accountController.getAccount()).getAccountNumber(), "deposit", Double.parseDouble(DepositText.getText()));
                    ATM.deposit(Double.parseDouble(DepositText.getText()));
                    System.out.println("Deposits: $" + DepositText.getText());
                    System.out.println("$" + accountController.getBalance());
                    currentBalance.setText("$" + accountController.getBalance());
                }
            }

            frame.getContentPane().repaint();
        }

        else if(e.getSource() == withdrawButton)
        {
            int withdraw = Integer.parseInt(WithdrawalText.getText());
            if(!WithdrawalText.getText().isEmpty() && withdraw > 0)
            {
                if(ATM.getAtmBalance() >= withdraw) {
                    if (withdraw % 20 == 0) {
                        accountController.withdraw(withdraw);
                        db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                        db.putTransacation(userController.getUserAccountNumber(), ((CheckingAccount) accountController.getAccount()).getAccountNumber(), "withdrawal", Double.parseDouble(WithdrawalText.getText()));
                        ATM.withdraw(withdraw);
                        System.out.println("Withdraws: $" + withdraw);
                        System.out.println("$" + accountController.getBalance());
                        currentBalance.setText("$" + accountController.getBalance());
                    }

                    else
                    {
                        System.out.println("Please ensure withdrawal is in multiples of 20.");
                    }
                }

                else
                {
                    System.out.println("Insufficient balance in ATM. Please logout and enter branch to complete transaction.");
                }


            }

            frame.getContentPane().repaint();
        }

        else if(e.getSource() == buyStampsButton)
        {
            if(!StampsText.getText().isEmpty())
            {
                int stamps = Integer.parseInt(StampsText.getText());

                if(stamps > 0)
                {
                    if(stamps <= ATM.getStampBalance())
                    {
                        accountController.withdraw(stamps * .55);
                        db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                        db.putTransacation(userController.getUserAccountNumber(), ((CheckingAccount) accountController.getAccount()).getAccountNumber(), "withdrawal", stamps * .55);
                        ATM.buyStamps(stamps);
                        currentBalance.setText("$" + accountController.getBalance());
                    }

                    else
                    {
                        System.out.println("Insufficient stamp balance in ATM. Please logout and enter branch to complete transaction.");
                    }
                }

                else
                {
                    System.out.println("Please enter a number greater than 1.");
                }
            }
            frame.getContentPane().repaint();
        }

        else if(e.getSource() == logOutButton)
        {
            new atmForm();
        }
    }
}

