package Generation;
import Account.*;
import Database.Database;
import User.*;

import java.util.Random;

public class NumberGeneration {
    private static String CheckPrefix = "1000",LoanPrefix = "3000",CreditPrefix= "2000",BankPrefix = "1234", BrokeragePrefix = "9000";
    private Database db;


    /**
     * Generates account numbers for user based on account type
     * @param accountType String type of account
     * @param user UserInterface
     * @return String
     */
    public static String accountNumberGenerator(String accountType, UserInterface user){
        String accNum="",
                userNum="";
        if(accountType.equalsIgnoreCase("checking")){
            accNum = CheckPrefix;
        }
        else if(accountType.equalsIgnoreCase("loan")){
            accNum = LoanPrefix;
        }
        else if(accountType.equalsIgnoreCase("credit")){
            accNum = CreditPrefix;
        }
        else if(accountType.equalsIgnoreCase("brokerage")){
            accNum = BrokeragePrefix;
        }

        if(user instanceof Client){
            userNum = clientNumberGenerator((Client) user);
            ((Client) user).setClientNumber(userNum);
        }
        else if(user instanceof Employee){
            userNum = employeeNumberGenerator((Employee)user);
            ((Employee) user).setEmployeeNumber(userNum);
            return userNum;
        }

        if(accNum.isEmpty() || userNum.isEmpty()){
            //Throw Exception
        }

        return BankPrefix + accNum + userNum;


    }


    /**
     * Generates a client number
     * @param client
     * @return String
     */
    public static String clientNumberGenerator(Client client){
        if(client.getClientNumber() != null && !client.getClientNumber().isEmpty()){
            return client.getClientNumber();
        }
            Random rand = new Random();
            return Integer.toString(rand.nextInt(9000) + 1000);

    }

    /**
     * Generates an employee number
     * @param employee
     * @return String
     */
    public static String employeeNumberGenerator(Employee employee){
        if(employee.getEmployeeNumber() !=null && !employee.getEmployeeNumber().isEmpty()){
            return employee.getEmployeeNumber();
        }
        Random rand = new Random();
        return Integer.toString(rand.nextInt(900)+100);

    }
}
