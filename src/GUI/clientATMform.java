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

    }
}
