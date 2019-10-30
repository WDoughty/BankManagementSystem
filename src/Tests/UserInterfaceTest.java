package Tests;

import Account.Account;
import Account.AccountInterface;
import Account.AccountControllerInterface;
import Account.AccountController;
import HR.Paycheck;
import HR.PaycheckInterface;
import User.Client;
import User.Employee;
import User.UserController;
import User.UserInterface;
import org.junit.Test;

import static org.junit.Assert.*;



//Just put all User Based tests in this class regardless if its not UserInterface specific
public class UserInterfaceTest {

    @Test
    public void setGetName(){
        String name = "Test";
        UserInterface user = new Client();
        UserController userController1 = new UserController(user);
        userController1.setUserName(name);
        assertEquals(name,userController1.getUserName());
        userController1.setUserName("Test2");
        assertNotEquals(name,userController1.getUserName());

    }

    @Test
    public void getUserAccountNumber(){
        String name = "Test";
        String accountNumber = "1234";
        UserInterface user1 = new Client();
        UserController userController2 = new UserController(user1);
        userController2.setUserName(name);
        userController2.setUserAccountNumber(accountNumber);
        assertEquals(accountNumber,userController2.getUserAccountNumber());
        assertNotEquals("4321",userController2.getUserAccountNumber());

        AccountInterface account = new Account((Client)user1, accountNumber);
        AccountControllerInterface controller = new AccountController(account);
        controller.deposit(10);
        assertEquals(10.00,controller.getBalance(),0);

    }

    @Test
    public void checkEmployee(){
        String name  = "Test";
        UserInterface user3 = new Employee();
        UserController userController3 = new UserController(user3);
        userController3.setEmployeeNumber("1234");
        userController3.setUserName(name);
        assertEquals("IncorrectUserException",userController3.getUserAccountNumber());
        userController3.setHoursWorked(10);
        userController3.setHourlyPay(10);
        PaycheckInterface paycheck = new Paycheck(userController3);
        paycheck.printPayStub();

        userController3.getTimeCard().testClockInOut();
        System.out.println(userController3.getTimeCard().getWorkedHours());


    }



}