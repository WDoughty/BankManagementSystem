package GUI;

import Database.Database;

import User.*;
import ATM.ATM;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.*;

public class atmForm implements ActionListener
{
    private JFrame frame;
    private JButton loginButton;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JPanel ATMpanel;
    private UserInterface userInterface;
    private Database db;
    private JLabel errLabel;

    public atmForm()
    {
        frame = ATM.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        atmPage();
        loginButton.addActionListener(this);

    }

    public void atmPage()
    {
        frame.setContentPane(ATMpanel);
        frame.setVisible(true);
    }


    public boolean login()
    {
        db = new Database();
        try
        {
            userInterface = db.getUser(usernameTextField.getText(), passwordField.getText());
        }

        catch(IncorrectUsernamePasswordException e)
        {
            System.out.println(e.toString());
            errLabel.setText(e.getMessage());
        }

        if(userInterface != null)
        {
            System.out.println("User: "+ userInterface.getName());
            if(userInterface instanceof Client){
                new clientATMform(userInterface);
            }
            else if(userInterface instanceof Employee) {
                new employeeATMform(userInterface);
            }
        }
        else{
            System.out.println("No user");
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource() == loginButton){
                if(!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty()) {
                    if (!login()) {
                        frame.getContentPane().setVisible(false);
                        frame.getContentPane().repaint();
                        frame.getContentPane().setVisible(true);
                    }
                }
            }
    }
}

