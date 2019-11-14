package GUI;

import Account.AccountControllerInterface;
import Account.AccountInterface;
import Database.Database;
import User.*;
import View.View;
import Exception.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarEntry;

public class LoginForm implements ActionListener {

    private JFrame frame;
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel errLabel;
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

    public boolean login()  {
        db = new Database();
        try {
            userInterface = db.getUser(usernameTextField.getText(), passwordField.getText());
        }
        catch(IncorrectUsernamePasswordException e){
            System.out.println(e.toString());
            errLabel.setText(e.getMessage());


        }
        if(userInterface != null){
            System.out.println("User: "+ userInterface.getName());
            if(userInterface instanceof Client){

                new accountsForm(userInterface);
            }
            else if(userInterface instanceof Employee){
                if(userInterface instanceof Manager){
                    new manager(userInterface);
                }
                else{
                    new employeeForm(userInterface);
                }

            }
            else if(userInterface instanceof Administrator){

            }
        }
        else{
            System.out.println("No user");

        }



        return false;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){
            if(!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty())
                if(!login()){
                    frame.getContentPane().setVisible(false);
                    frame.getContentPane().repaint();
                    frame.getContentPane().setVisible(true);
                }

        }

    }


}
