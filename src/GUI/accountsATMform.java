package GUI;

import Account.Account;
import Database.Database;
import User.Client;
import User.UserInterface;
import Account.AccountInterface;
import ATM.ATM;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class accountsATMform extends DefaultListCellRenderer implements ListSelectionListener, ActionListener
{
    private JList<Object> accountList;
    private JPanel accountATMpanel;
    private JButton logoutButton;
    private Database db;
    private List<Account> accounts;

    private JFrame frame;
    private UserInterface userInterface;
    private AccountInterface accountInterface;

    public accountsATMform(UserInterface userInterface)
    {
        this.userInterface = userInterface;
        frame = ATM.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(accountATMpanel);
        frame.revalidate();
        frame.getContentPane().setVisible(true);
        frame.setVisible(true);
        accountList.setLayoutOrientation(JList.VERTICAL);
        db = new Database();
        accounts = db.getAccounts((Client)userInterface);
        for(int i=0;i<accounts.size();i++){
            System.out.println(accounts.get(i).getAccountNumber() +" "+ accounts.get(i).getClass());
        }
        DefaultListModel listModel = new DefaultListModel();
        for(int i=0;i<accounts.size();i++){
            listModel.addElement(accounts.get(i));
        }
        accountList.setModel(listModel);
        accountList.setCellRenderer(this);
        accountList.addListSelectionListener(this);
    }


    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        if(value instanceof Account){
            setText(((Account) value).getAccountNumber() + "   $" + ((Account) value).getBalance());
            setToolTipText(value.getClass().toString().substring(value.getClass().toString().indexOf(".")+1));
        }
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == logoutButton)
        {
            new atmForm();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        Account sv = (Account)((JList)e.getSource()).getSelectedValue();
        new clientATMform(userInterface,sv);
    }
}
