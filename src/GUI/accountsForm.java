package GUI;

import Account.Account;
import Database.Database;
import User.Client;
import User.UserController;
import User.UserInterface;
import View.View;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Account.*;


public class accountsForm extends DefaultListCellRenderer implements ListSelectionListener, ActionListener {
    private JList<Object> accountList;
    private JPanel panel1;
    private JButton loanApply;
    private JButton settingsButton;
    private JButton logoutButton;
    private JButton statementButton;
    private Database db;
    private List<Account> accounts;
    private JFrame frame;
    private UserInterface userInterface;
    private AccountInterface accountInterface;

    /**
     * Creates a new Account form
     * @param userInterface
     */
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
        loanApply.addActionListener(this);
        settingsButton.addActionListener(this);
        logoutButton.addActionListener(this);
        statementButton.addActionListener(this);
    }

    /**
     * List Action Listener
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if(((JList) e.getSource()).getSelectedValue() instanceof CheckingAccount) {
            Account sv = (Account) ((JList) e.getSource()).getSelectedValue();
            new clientForm(userInterface, sv);
        }
        else if( ((JList) e.getSource()).getSelectedValue() instanceof BrokerageAccount){
            Account sv = (Account) ((JList) e.getSource()).getSelectedValue();
            UserController userController = new UserController(userInterface);
            new Brokerage(userController, sv);
        }

        else if(((JList) e.getSource()).getSelectedValue() instanceof LoanAccount
                || ((JList) e.getSource()).getSelectedValue() instanceof  CreditAccount){
            Account sv = (Account) ((JList) e.getSource()).getSelectedValue();
            UserController userController = new UserController(userInterface);
            new clientForm(userInterface,sv);
        }
    }

    /**
     * List Cell Renderer
     * @param list
     * @param value
     * @param index
     * @param isSelected
     * @param cellHasFocus
     * @return
     */
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        if(value instanceof Account){
            setText(((Account) value).getAccountNumber() + "   $" + ((Account) value).getBalance());
            setToolTipText(value.getClass().toString().substring(value.getClass().toString().indexOf(".")+1));
        }
        return this;
    }

    /**
     * Button Action Listener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loanApply){
            new LoanApplication(userInterface);
        }
        else if(e.getSource() == settingsButton){
            new Settings(userInterface);
        }
        else if(e.getSource() == logoutButton){
            new LoginForm();
        }

        else if (e.getSource() == statementButton){
            new HistoryForm(userInterface);

        }

    }
}
