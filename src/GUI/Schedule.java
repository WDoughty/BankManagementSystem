package GUI;

import Database.Database;
import User.Employee;
import User.Manager;
import User.UserInterface;
import View.View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Schedule extends DefaultListCellRenderer implements ListSelectionListener, ActionListener
{
    private List<Employee> list;
    private Database db;
    private JList<Object> Employees;
    private JPanel panel1;
    private JButton backButton;
    private JButton logoutButton;
    private UserInterface user;
    private JFrame frame;

    public Schedule(UserInterface user)
    {
        this.user = user;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(panel1);
        frame.revalidate();
        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
        backButton.addActionListener(this);
        logoutButton.addActionListener(this);
        Employees.setLayoutOrientation(JList.VERTICAL);
        db = new Database();
        list = db.getEmployees();
        DefaultListModel listModel = new DefaultListModel();
        for(int i=0;i<list.size();i++){
            listModel.addElement(list.get(i));
        }
        Employees.setModel(listModel);
        Employees.setCellRenderer(this);
        Employees.addListSelectionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == backButton)
        {
            new manager(user);
        }

        if(e.getSource() == logoutButton)
        {
            new LoginForm();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        Employee emp = (Employee)((JList)e.getSource()).getSelectedValue();
        new EmployeeManage(emp,user);
    }
}
