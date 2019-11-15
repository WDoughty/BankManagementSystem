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
//        Manager test = new Manager();
//        test.setEmployeeNumber("100");
//        test.setName("Manager Test2");
//        test.setHourlyPay(25.00);
//        test.setHoursWorked(40);
//        test.setPassword("password");
//        db.putEmployee(test);

        Employee employee = new Employee();
        employee.setEmployeeNumber(NumberGeneration.employeeNumberGenerator(employee));
        employee.setHourlyPay(10);
        employee.setHoursWorked(10);
        employee.setName("Employee1 Test1");
        employee.setPassword("1234");
        db.putEmployee(employee);

    }

}