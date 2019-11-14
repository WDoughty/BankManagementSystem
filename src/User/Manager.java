package User;


import Database.Database;

import java.util.List;

public class Manager extends Employee {
    List<Employee> list;
    public Manager() {
        super();
    }

    public void getEmployeesHoursWorked() {
        Database db = new Database();
        list = db.getEmployees();

    }

    public double calculatePayRollExpenses(){
        double total=0;
        for(int i=0;i<list.size();i++){
            total += list.get(i).getHourlyPay() * list.get(i).getHoursWorked();
        }
        return total;
    }

}






