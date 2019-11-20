//package GUI;
//
//import Database.Database;
//
//import User.*;
//import View.View;
//import ATM.ATM;
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class atmForm implements ActionListener
//{
//    private JFrame frame;
//    private JButton loginButton;
//    private JTextField usernameTextField;
//    private JPasswordField passwordField;
//    private JPanel ATMpanel;
//    private UserInterface userInterface;
//    private Database db;
//
//    public atmForm()
//    {
//        frame = ATM.getFrame();
//        frame.getContentPane().setVisible(false);
//        frame.getContentPane().repaint();
//        atmPage();
//        loginButton.addActionListener((ActionListener) this);
//
//    }
//
//    public void atmPage()
//    {
//        frame.setContentPane(ATMpanel);
//        frame.setVisible(true);
//    }
//
//
//    public boolean login()
//    {
//        db = new Database();
//        userInterface = db.getUser(usernameTextField.getText());
//        if(userInterface != null)
//        {
//            System.out.println("User: "+ userInterface.getName());
//            if(userInterface instanceof Client){
//                //new clientForm(userInterface);
//                new clientATMform(userInterface);
//            }
//            else if(userInterface instanceof Employee)
//            {
//                new employeeATMform(userInterface);
//            }
//            else if(userInterface instanceof Administrator)
//            {
//
//            }
//        }
//        else{
//            System.out.println("No user");
//        }
//
//        return false;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e)
//    {
//        if(e.getSource() == loginButton)
//        {
//            if(!usernameTextField.getText().isEmpty() && !passwordField.getText().isEmpty())
//            {
//                if (usernameTextField.getText().equals(userInterface.getPassword()))
//                {
//                    login();
//                }
//
//                else
//                {
//                    System.out.println("Password Incorrect");
//                }
//            }
//        }
//    }
//}
//
