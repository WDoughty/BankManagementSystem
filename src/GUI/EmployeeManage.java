package GUI;

import User.Employee;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManage implements ActionListener
{
    private JComboBox comboBox1;
    private JButton OKButton;
    private JButton logoutButton;
    private JButton backButton;
    private JPanel panel1;
    private JTextField name;
    private JTextField Position;
    private UserInterface user;
    private JFrame frame;

    public EmployeeManage(UserInterface user)
    {
        this.user = user;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(panel1);
        name.setText(user.getName());
        Position.setText(((Employee) user).getPosition());
        frame.revalidate();
        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
        backButton.addActionListener(this);
        logoutButton.addActionListener(this);
        OKButton.addActionListener(this);
        comboBox1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == OKButton)
        {
            int index = comboBox1.getSelectedIndex();
            switch (index)
            {
                case 1:
                    ((Employee) user).setPosition("Teller");
                    break;
                case 2:
                    ((Employee) user).setPosition("Security");
                    break;
                case 3:
                    ((Employee) user).setPosition("Loan Specialist");
            }
            Position.setText(((Employee) user).getPosition());
            frame.getContentPane().setVisible(false);
            frame.getContentPane().repaint();
            frame.getContentPane().setVisible(true);
        }

        else if(e.getSource() == backButton)
        {
            new Schedule(user);
        }

        else if(e.getSource() == logoutButton)
        {
            new LoginForm();
        }
    }
}
