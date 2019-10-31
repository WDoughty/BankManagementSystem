package Database;

import java.sql.Connection;
import java.time.LocalDateTime;
import Account.Account;
import User.Client;

public interface DatabaseInterface {

    boolean putClient(Client c);

    void addShift(String eid, LocalDateTime start, LocalDateTime finish);

    void getShifts(String eid);

    boolean putAccount(Account a);

    boolean getUser(String uid);

    Account getAccount(Client client, String aid);

    Connection getConnection();
}
