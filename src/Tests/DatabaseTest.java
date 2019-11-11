package Tests;

import Account.*;
import Database.Database;
import Generation.NumberGeneration;
import User.*;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void dataBaseSetUpTest(){


        Database db = new Database();
        Employee test = new Employee();
        test.setHourlyPay(10.00);
        test.setName("Employee Test");
        test.setPassword("password");
        test.setEmployeeNumber(NumberGeneration.employeeNumberGenerator(test));
        db.putEmployee(test);
    }

}