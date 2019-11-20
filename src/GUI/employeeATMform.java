package GUI;

import User.UserInterface;
import View.View;
import ATM.ATM;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class employeeATMform implements ActionListener
{
    private JFrame frame;
    private JPanel employeeATM;
    private UserInterface userInterface;
    private JButton viewLogButton;
    private JButton fillCashButton;
    private JButton fillStampsButton;
    private JButton clearLogButton;
    private JButton viewCashAndStampsButton;
    private JButton emptyDepositsButton;
    private JButton logoutButton;
    private JPanel EmployeeATM;

    public employeeATMform(UserInterface userInterface)
    {
        this.userInterface = userInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(employeeATM);
        logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == logoutButton){
            userInterface = null;
            new LoginForm();
        }

        if(e.getSource() == fillCashButton)
        {
            ATM.cashFill();
        }

        if(e.getSource() == fillStampsButton)
        {
            ATM.stampFill();
        }

        if(e.getSource() == viewLogButton)
        {
            System.out.println(ATM.viewLog());
        }

        if(e.getSource() == viewCashAndStampsButton)
        {
            System.out.println(ATM.viewCS());
        }

        if(e.getSource() == clearLogButton)
        {
            ATM.clear();
        }

        if(e.getSource() == emptyDepositsButton)
        {
            ATM.emptyDeposits();
        }
    }
}
