package GUI;

import Account.AccountControllerInterface;
import Account.AccountInterface;
import Database.Database;
import User.UserController;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm implements ActionListener {

    private JFrame frame;
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private AccountControllerInterface accountController;
    private UserInterface userInterface;
    private UserController userController;
    private AccountInterface account;
    private Database db;

    public LoginForm(){
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        loginPage();
        loginButton.addActionListener(this);

    }


    public void loginPage(){
        frame.setContentPane(loginPanel);
        frame.setVisible(true);
    }

    public boolean login(){
        db = new Database();
        userInterface = db.getUser(usernameTextField.getText());
        if(userInterface != null){
            System.out.println("User: "+ userInterface.getName());
            new clientForm(userInterface);
        }
        else{
            System.out.println("No user");
        }



        return false;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            if(!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty()) login();

        }

    }

}
