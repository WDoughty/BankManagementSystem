package HR;

import User.Employee;

import java.util.Date;


public class EmployeeTimeClock implements EmployeeTimeClockInterface {
    private int startTime;
    private int stopTime;

    @Override
    public void clockIn() {
        Date date = new Date();
        int hours = date.getHours();

        int minutes = date.getMinutes();
        minutes = minutes + hours*60;
        startTime = minutes;

    }

    @Override
    public void clockOut() {
        Date date = new Date();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        minutes = minutes + hours*60;
        stopTime = minutes;


    }

    @Override
    public double getWorkedHours() {
        double hours = (stopTime-startTime / 60.00);
        return hours;
    }
}
