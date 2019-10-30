package HR;

import User.Employee;
import User.UserController;
import java.util.Calendar;



public class EmployeeTimeCard implements EmployeeTimeCardInterface {
    private int startTime;
    private int stopTime;


    @Override
    public void clockIn() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        minutes = minutes + hours*60;
        startTime = minutes;

    }

    @Override
    public void clockOut() {
        Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        minutes = minutes + hours*60;
        stopTime = minutes;
    }
    @Override
    public double getWorkedHours() {
        double hours = ((stopTime-startTime) / 60.00);
        return hours;
    }

    /**
     * This method is only used for testing. Given in minutes
     */
    public void testClockInOut(int startTime, int stopTime){
        this.startTime =  startTime*60;
        this.stopTime = stopTime*60;
    }
}
