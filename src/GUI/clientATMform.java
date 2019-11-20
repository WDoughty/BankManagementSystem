package GUI;

import ATM.ATM;
import Account.AccountInterface;
import Database.Database;
import User.UserInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientATMform implements ActionListener
{
    private JFrame frame;
    private UserInterface userInterface;
    private JPanel clientATMform;
    private JTextField DepositText;
    private JTextField WithdrawalText;
    private JTextField StampsText;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton buyStampsButton;
    private JButton logOutButton;
    private Database db;

    public clientATMform(UserInterface userInterface)
    {
        this.userInterface = userInterface;
        frame = ATM.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(clientATMform);
        frame.revalidate();
        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
        db = new Database();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == depositButton)
        {
            if()
        }

        if(e.getSource() == withdrawButton)
        {

        }

        if(e.getSource() == buyStampsButton)
        {

        }
        if(e.getSource() == logOutButton)
        {
            new atmForm();
        }
    }
}
