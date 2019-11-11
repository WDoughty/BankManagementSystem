package GUI;

import Account.*;
import Database.Database;
import Generation.NumberGeneration;
import User.Client;
import User.Employee;
import User.UserController;
import User.UserInterface;
import View.View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class createUser implements ActionListener {

    private JTextField nameField;
    private JTextField passwordField;
    private JSpinner accountSpinner;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JPanel createUserPanel;
    private JButton createUserButton;
    private JTextField clientNumField;
    private JLabel clientNum;
    private JButton backButton;
    private UserInterface userInterface;
    private JFrame frame;
    private Database db;


    public createUser(UserInterface userInterface){
        List<String> list = new ArrayList<>();
        list.add("checking");
        list.add("loan");
        list.add("credit");
        list.add("employee");
        list.add("administrator");
        SpinnerListModel model = new SpinnerListModel();
        model.setList(list);
        accountSpinner.setModel(model);

        db = new Database();
        this.userInterface = userInterface;
        frame = View.getFrame();
        frame.getContentPane().setVisible(false);
        frame.getContentPane().repaint();
        frame.getContentPane().removeAll();
        frame.setContentPane(createUserPanel);
        createUserButton.addActionListener(this);
        backButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == createUserButton){
            makeUser();
        }
        else if(e.getSource() == backButton){
            new employeeForm(userInterface);
        }

    }


    public void makeUser(){
        if(!nameField.getText().isEmpty() && nameField.getText() !=null
                & !passwordField.getText().isEmpty() && passwordField.getText() != null){
            String type = accountSpinner.getValue().toString();
            UserInterface newUser;
            String userNum;
            if(type.equalsIgnoreCase("employee")){
                newUser = new Employee();
                userNum = NumberGeneration.accountNumberGenerator(type,(Employee)newUser);
            }
            else{
                newUser = new Client();
                if(!clientNumField.getText().isEmpty() && clientNumField.getText()!=null){
                    UserController userController = new UserController((Client)newUser);
                    userController.setUserAccountNumber(clientNumField.getText());
                }
                userNum = NumberGeneration.accountNumberGenerator(type, (Client) newUser);

            }
            newUser.setName(nameField.getText());
            newUser.setPassword(passwordField.getText());
            db = new Database();
            if(newUser instanceof  Client){
                db.putClient((Client)newUser);

                Account account;
                if(type.equalsIgnoreCase("checking")){
                    account = new CheckingAccount((Client) newUser,userNum);
                    db.putCheckingAccount((CheckingAccount)account,((Client) newUser).getClientNumber());
                }
                else if(type.equalsIgnoreCase("loan")){
                    account = new LoanAccount((Client) newUser,userNum);
                    db.putLoanAccount((LoanAccount) account, ((Client) newUser).getClientNumber());
                }
                else if(type.equalsIgnoreCase("credit")){
                    account = new CreditAccount((Client)newUser,userNum);
                    db.putCreditAccount((CreditAccount)account,((Client) newUser).getClientNumber());
                }
            }
            else if(newUser instanceof Employee){
                db.putEmployee((Employee)newUser);
            }
        }
    }
}
