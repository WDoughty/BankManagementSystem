package Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import Account.Account;
import User.UserInterface;

public interface DatabaseInterface {
  public Connection connection = null;
  
  public boolean putUser(UserInterface u) {
    //TODO
    try {
      connection = this.getConnection();
      Statement s = connection.getStatement();
      if (u.getUserAccountNumber != null) {
        s.executeUpdate("insert into users values (u.getUserName, u.getAccountNumber");
  }
  
  public boolean putAccount(Account a) {
    //TODO
  }
  
  public boolean getUser(String uid) {
    //TODO
  }
  
  public boolean getAccount(String aid) {
    //TODO
  }
  
  public Connection getConnection() {
    try {
      connection = DriverManager.getConnection ("jdbc:mysql://localhost/BankManagementSystem", "root", "password");
    }
    catch(ClassNotFOundException nfe) {
      connection = null;
    }
    catch(SQLException sqle) {
      connection = null;
    }
    return connection;
  }
}
