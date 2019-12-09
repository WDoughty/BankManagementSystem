package GUI;

import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeForm implements ActionListener {
    private JFrame frame;
    private JButton createNewUserButton,clockInButton,clockOutButton,searchAccountButton,viewPaystubButton,logoutButton;
    private JPanel employeePanel;
    private UserInterface userInterface;

    /**
     * Creates a new employee form
     * @param userInterface
     */
    public employeeForm(UserInterface userInterface){
        this.userInterface = userInterface;
       frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(employeePanel);
        createNewUserButton.addActionListener(this);
        logoutButton.addActionListener(this);


    }

    /**
     * Button Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createNewUserButton){
            new createUser(userInterface);
        }

        else if(e.getSource() == logoutButton){
            userInterface = null;
            new LoginForm();
        }
    }
}
