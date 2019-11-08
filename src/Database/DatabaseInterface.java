package Database;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Account.Account;
import Account.CheckingAccount;
import Account.CreditAccount;
import Account.LoanAccount;
import HR.Shift;
import User.Administrator;
import User.Client;
import User.Employee;
import User.UserInterface;

public interface DatabaseInterface {

    boolean putClient(Client c);

    boolean putAdministrator(Administrator a);

    boolean putEmployee(Employee e);

    boolean addShift(String sid, String eid, LocalDateTime start, LocalDateTime finish);

    boolean putCheckingAccount(CheckingAccount a, String cid);

    boolean putCreditAccount(CreditAccount a, String cid);

    boolean putLoanAccount(LoanAccount a, String cid);

    Shift getShifts(String sid);

    UserInterface getUser(String uid);

    Employee getEmployee(String eid);

    Client getClient(String cid);

    Administrator getAdministrator(String aid);

    List<Account> getAccounts(Client client);

    CheckingAccount getCheckingAccount( Client client);

    CreditAccount getCreditAccount( Client client);

    LoanAccount getLoanAccount(Client client);

    Connection getConnection();
}
