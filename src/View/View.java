package View;

import ATM.ATM;
import Account.CheckingAccount;
import Account.CreditAccount;
import Account.LoanAccount;
import Database.Database;
import HR.Shift;
import User.Administrator;
import User.Client;
import User.Employee;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.Month;

public class View {

    public static void main(String args[]){
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

        Database db = new Database();
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

        Client guy8 = new Client();
        guy8.setName("Jasmine");
        guy8.setAccountNumber("100000");
        guy8.setPassword("pass6");
//        db.putClient(guy8);

        CheckingAccount  account = new CheckingAccount(guy8, "151515");
        account.deposit(1000);
        db.putCheckingAccount(account, "100000");

//        System.out.println(account.getBalance());
    }
}
