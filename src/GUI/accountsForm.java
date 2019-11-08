package GUI;

import Account.Account;
import Database.Database;
import User.Client;
import User.UserInterface;
import View.View;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import Account.*;
import com.sun.javafx.css.parser.LadderConverter;

public class accountsForm extends DefaultListCellRenderer implements ListSelectionListener {
    private JList<Object> accountList;
    private JPanel panel1;
    private Database db;
    private List<Account> accounts;
    private JFrame frame;
    private UserInterface userInterface;
    private AccountInterface accountInterface;

    public accountsForm(UserInterface userInterface){
        this.userInterface = userInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(panel1);
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Account sv = (Account)((JList)e.getSource()).getSelectedValue();
        new clientForm(userInterface,sv);
    }

    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        if(value instanceof Account){
            setText(((Account) value).getAccountNumber() + "   $" + ((Account) value).getBalance());
            setToolTipText(value.getClass().toString().substring(value.getClass().toString().indexOf(".")+1));
        }
        return this;
    }
}