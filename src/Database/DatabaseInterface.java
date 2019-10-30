package Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DatabaseInterface {
  private connection = null;
  
  public boolean putUser(User u) {
    //todo
    try {
      connection = this.getConnection();
      Statement s = connection.getStatement();
      if (u.getUserAccountNumber != null) {
        s.executeUpdate("insert into users values (u.getUserName, u.getAccountNumber");
  }
  
  public boolean putAccount(Account a) {
    //todo
  }
  
  public boolean getUser(String uid) {
    //todo
  }
  
  public boolean getAccount(String aid) {
    //todo
  }
  
  private Connection getConnection() {
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
