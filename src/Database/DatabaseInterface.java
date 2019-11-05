package Database;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Account.Account;
import Account.CheckingAccount;
import Account.CreditAccount;
import Account.LoanAccount;
import HR.Shift;
import User.Administrator;
import User.Client;
import User.Employee;

public interface DatabaseInterface {

    boolean putClient(Client c);

    boolean putAdministrator(Administrator a);

    boolean putEmployee(Employee e);

    boolean addShift(String sid, String eid, LocalDateTime start, LocalDateTime finish);

    boolean putCheckingAccount(CheckingAccount a, String cid);

    boolean putCreditAccount(CreditAccount a, String cid);

    boolean putLoanAccount(LoanAccount a, String cid);

    Shift getShifts(String sid);

    boolean getUser(String uid);

    Employee getEmployee(String eid);

    Client getClient(String cid);

    Administrator getAdministrator(String aid);

    Account getAccount(Client client, String aid);

    Connection getConnection();
}
