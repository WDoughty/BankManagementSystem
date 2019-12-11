package GUI;

import User.Employee;
import User.UserInterface;
import View.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Database.*;
public class EmployeeManage implements ActionListener
{
    private JComboBox comboBox1;
    private JButton OKButton;
    private JButton logoutButton;
    private JButton backButton;
    private JPanel panel1;
    private JTextField name;
    private JLabel Position;
    private UserInterface user,other;
    private JFrame frame;
    private Database db;

    public EmployeeManage(UserInterface user, UserInterface other)
    {
        db = new Database();
        this.user = user;
        this.other = other;
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
                case 0:
                    ((Employee) user).setPosition("Teller");
                    break;
                case 1:
                    ((Employee) user).setPosition("Security");
                    break;
                case 2:
                    ((Employee) user).setPosition("Loan Specialist");
                    break;
            }
            Position.setText(((Employee) user).getPosition());
            db.putEmployee((Employee) user);
            frame.getContentPane().setVisible(false);
            frame.getContentPane().repaint();
            frame.getContentPane().setVisible(true);
        }

        else if(e.getSource() == backButton)
        {
            new Schedule(other);
        }

        else if(e.getSource() == logoutButton)
        {
            new LoginForm();
        }
    }
}
