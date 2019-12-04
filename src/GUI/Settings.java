package GUI;

import Database.Database;
import User.Client;
import User.UserController;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings implements ActionListener {
    private JTextField emailField;
    private JButton passwordButton;
    private JButton emailButton;
    private JTextField passwordField;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JPanel settingsPanel;
    private JButton backButton;
    private UserInterface userInterface;
    private JFrame frame;
    private Database db;

    public Settings(UserInterface userInterface){
        db = new Database();
        this.userInterface = userInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(settingsPanel);
        passwordButton.addActionListener(this);
        emailButton.addActionListener(this);
        backButton.addActionListener(this);
        frame.getContentPane().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == emailButton){
            if(!emailField.getText().isEmpty() && emailField.getText() !=null){
                changeEmail(emailField.getText());
            }
        }
        else if(e.getSource() == passwordButton){
            if(!passwordField.getText().isEmpty() && passwordField.getText() !=null){
                changePassword(passwordField.getText());
            }
        }
        else if(e.getSource() == backButton){
            new accountsForm(userInterface);
        }
    }

    public void changeEmail(String email){
        if(userInterface instanceof Client){
            ((Client) userInterface).setEmail(email);
            db.putClient((Client) userInterface);
        }

    }

    public void changePassword(String password){
        userInterface.setPassword(password);
        if(userInterface instanceof Client){
            db.putClient((Client) userInterface);
        }
        //Do other classes
    }
}
