package GUI;

import User.Manager;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager implements ActionListener {
    private JButton calculateExpenses;
    private JPanel managerPanel;
    private JLabel payrollExpenses;
    private UserInterface user;
    private JFrame frame;

    /**
     * Creates a new Manager form
     * @param user
     */
    public manager(UserInterface user){
        this.user=user;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.setContentPane(managerPanel);
        calculateExpenses.addActionListener(this);
        frame.getContentPane().setVisible(true);

    }

    /**
     * Button Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calculateExpenses){
            ((Manager) user).getEmployees();
            double temp = ((Manager)user).calculatePayRollExpenses();
            payrollExpenses.setText("$" + temp);
            frame.getContentPane().setVisible(false);
            frame.getContentPane().repaint();
            frame.getContentPane().setVisible(true);
        }
    }
}
