package View;

import ATM.ATM;
import Account.*;
import Database.Database;
import HR.Paycheck;
import HR.PaycheckInterface;
import HR.Shift;
import User.*;
import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;
import com.sun.xml.internal.ws.client.ClientTransportException;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class View implements ActionListener{

    private JTextField usernameField, passwordField,depositField,withdrawField,accountField;
    private JFrame frame;
    private JButton loginButton,depositButton,withdrawButton;
    private AccountControllerInterface accountController;
    private UserInterface userInterface;
    private UserController userController;
    private AccountInterface account;
    private Database db;

    public View(){
        GUI();
    }

    public static void main(String args[]) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                View view = new View();
            }
        });

    }

    private void GUI(){
        frame = new JFrame("Bank Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        // Create Panels for login procedure
        JPanel panel1 = new JPanel(new GridLayout(5, 1));
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        Label userNameLabel = new Label("Enter username");
        panel1.add(userNameLabel);
        usernameField = new JTextField("username");
        panel1.add(usernameField);
        Label passwordLabel = new Label("Enter password");
        panel1.add(passwordLabel);
        passwordField = new JTextField("password");
        panel1.add(passwordField);
        Label accountNumber = new Label("Enter account number");
        accountField = new JTextField("");
        panel1.add(accountNumber);
        panel1.add(accountField);
        loginButton = new JButton("Login");
        panel1.add(loginButton);


        contentPane.add(panel1);
        frame.setVisible(true);
        loginButton.addActionListener(this);




    }

    private void loginUser(String username, String password) {
        db = new Database();
        userInterface = db.getClient(username);
        if(userInterface != null) {
            userController = new UserController(userInterface);
            System.out.println(userController.getUserName());

            account = db.getCheckingAccount(accountField.getText(), (Client) userInterface);
            accountController = new AccountController(account);
            showClientView();
        }
        else{
            Label label = new Label("Incorrect Username or Password");
            frame.setVisible(false);
            frame.add(label);
            frame.repaint();
            frame.setVisible(true);

        }

    }

    private void showClientView(){
        frame.setVisible(false);
        frame.getContentPane().removeAll();
        Container contentPane = frame.getContentPane();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5,1));
        JPanel panel = new JPanel(new GridLayout(1,2));
        JPanel panel2 = new JPanel(new GridLayout(1,2));
        JPanel panel3 = new JPanel(new GridLayout(1,1));

        Label depositLbl = new Label("Deposit",JLabel.CENTER);
        depositField = new JTextField();
        depositButton = new JButton("Deposit");
        panel.add(depositLbl);
        panel.add(depositField);



        Label currentBalance = new Label("Account Balance: $"+ accountController.getBalance());


        withdrawButton = new JButton("Withdraw");
        Label withdrawLbl = new Label("Withdraw",JLabel.CENTER);
        withdrawField = new JTextField();
        panel2.add(withdrawLbl);
        panel2.add(withdrawField);
        panel3.add(currentBalance);
        contentPane.add(panel,0);

        frame.add(depositButton,1);
        contentPane.add(panel2,2);
        frame.add(withdrawButton,3);
        contentPane.add(panel3,4);
        frame.setVisible(true);
        frame.repaint();
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == loginButton){
            String username = usernameField.getText();
            String password = passwordField.getText();
            System.out.println(username + " " + password);
            loginUser(username,password);
        }
        else if(e.getSource() == depositButton){
            if(!depositField.getText().isEmpty() && verifyInput(depositField.getText())){
                accountController.deposit(Double.parseDouble(depositField.getText()));
                db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                System.out.println("Deposits: $"+ depositField.getText());
                System.out.println("$" + accountController.getBalance());

            }
            showClientView();

        }

        else if(e.getSource() == withdrawButton){
            if(!withdrawField.getText().isEmpty() && verifyInput(withdrawField.getText())){
                accountController.withdraw(Double.parseDouble(withdrawField.getText()));
                db.putCheckingAccount((CheckingAccount) accountController.getAccount(), userController.getUserAccountNumber());
                System.out.println("Withdraws: $"+withdrawField.getText());
                System.out.println("$" + accountController.getBalance());
                showClientView();
            }
            showClientView();
        }


    }

    public boolean verifyInput(String s){
        return Double.parseDouble(s) >0;

    }



//        Scanner in = new Scanner(System.in);
//
//        UserInterface user;
//        System.out.println("Enter 1 for client, 2 for Employee");
//        int opt= in.nextInt();
//
//        if(opt == 1){
//            user = new Client();
//            System.out.println("Enter account number");
//        }
//        else{
//            user = new Employee();
//            System.out.println("Enter employee number");
//        }
//        String username = in.next();
//        System.out.println("Enter password");
//        String password = in.next();
//        UserController controller = new UserController(user);
//        System.out.println("Enter your first name");
//        user.setName(in.next());
//
//
//        if(user instanceof Client){
//            AccountInterface accountInterface = new Account((Client)user,"123456789");
//            AccountControllerInterface accountController = new AccountController(accountInterface);
//            boolean done =false;
//            while(!done){
//                System.out.println("Enter 1 to add funds, 2 to withdraw funds, or 3 to check balance,4 to logout");
//                opt = in.nextInt();
//                if(opt == 1){
//                    System.out.println("Enter amount to deposit");
//                    int amount = in.nextInt();
//                    accountController.deposit(amount);
//                }
//                else if(opt == 2){
//                    System.out.println("Enter amount to withdraw");
//                    int amount = in.nextInt();
//                    accountController.withdraw(amount);
//                }
//
//                else if(opt ==3){
//                    System.out.println("$"+accountController.getBalance());
//                }
//                else if(opt ==4){
//                    done =true;
//                }
//
//            }
//        }
//
//        else if(user instanceof Employee) {
//            boolean done = false;
//            controller.setEmployeeNumber(username);
//            while (!done) {
//                System.out.println("Enter 1 to check hours worked, 2 print paystub, 3 to clock out, 4 to clock in, or 5 to log out ");
//                opt = in.nextInt();
//                if (opt == 1) {
//                    System.out.println(controller.getEmployeeHoursWorked());
//
//                } else if (opt == 2) {
//                    PaycheckInterface paycheck = new Paycheck(controller);
//                    paycheck.paycheckUpdate();
//                    paycheck.printPayStub();
//
//                } else if (opt == 3) {
//                    controller.getTimeCard().clockIn();
//
//                } else if (opt == 4) {
//                    controller.getTimeCard().clockOut();
//
//                }
//                else if(opt ==5){
//                    done =true;
//                }
//            }
//        }
//        Employee guy = new Employee();
//        guy.setName("Janice");
//        guy.setEmployeeNumber("666666");
//        guy.setPassword("pass5");
//        guy.setHourlyPay(13.50);
//
//        Database db = new Database();
//
//        db.putEmployee(guy);

//        Administrator guy2 = new Administrator();
////
////        Database db = new Database();
////        guy2 = db.getAdministrator("444444");
////        System.out.println(guy2.getPassword());

//        Client guy3 = new Client();
//        guy3.setAccountNumber("333333");

//        CheckingAccount acc1 = new CheckingAccount(guy3, "121212");
//        acc1.deposit(500);
//        Database db = new Database();
//        System.out.print(acc1.getBalance());
//        db.putCheckingAccount(acc1, guy3.getAccountNumber());

//        CreditAccount acc2 = new CreditAccount(guy3, "131313");
//        acc2.deposit(500);
//        acc2.setInterestRate(5);
//        acc2.setCreditLine(1500);
//        Database db = new Database();
//        db.putCreditAccount(acc2, guy3.getAccountNumber());

//        LoanAccount acc3 = new LoanAccount(guy3, "141414");
//        acc3.deposit(500);
//        acc3.setInterestRate(7);
//        Database db = new Database();
//        db.putLoanAccount(acc3, guy3.getAccountNumber());

//        Database db = new Database();
//        LocalDateTime start = LocalDateTime.of(2019, Month.NOVEMBER, 5, 8, 0, 0);
//        LocalDateTime finish = LocalDateTime.of(2019, Month.NOVEMBER, 5, 16, 0, 0);
//        db.addShift("212121", "222222", start, finish);

//        Shift s1 = new Shift();
//        s1 = db.getShifts("000001");
//        System.out.println(s1.getFinish());

//        Client guy4 = new Client();
//        guy4.setAccountNumber("333333");
//        guy4.setName("Joanne");
//        CheckingAccount account = db.getCheckingAccount("121212", guy4);

//        Client guy5 = new Client();
//        guy5.setAccountNumber("333333");
//        guy5.setName("Joanne");
//        CreditAccount account = db.getCreditAccount("131313", guy5);

//        Client guy6 = new Client();
//        guy6.setAccountNumber("333333");
//        guy6.setName("Joanne");
//        LoanAccount account = db.getLoanAccount("141414", guy6);

//        Client guy7 = db.getClient("333333");
//
//        ATM atm = new ATM();
//        atm.userLogin(guy7.getAccountNumber(), guy7.getPassword(), "121212");
//        atm.buyStamps(20);
//        CheckingAccount account = db.getCheckingAccount("121212", guy7);

//        Client guy8 = new Client();
//      UserController guy8Controller = new UserController(guy8);
//        guy8Controller.setUserName("Jasmine");
//        guy8Controller.setUserAccountNumber("100000");
//        guy8Controller.setPassword("pass6");

//        db.putClient(guy8);

//        CheckingAccount  account = new CheckingAccount(guy8, "151515");
//        account.deposit(1000);
//       db.putCheckingAccount(account, "100000");

//        System.out.println(account.getBalance());
    }

