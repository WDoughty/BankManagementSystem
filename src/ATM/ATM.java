package ATM;

import Account.*;
import Database.Database;
import User.*;
import GUI.*;
import javax.swing.*;
import java.awt.*;

import java.awt.*;
import java.util.ArrayList;

public class ATM
{
	private Database db;
	private static int stampTotal = 4000;
	private static int atmBalance = 10000;
	private static ArrayList<Double> deposits = new ArrayList<>();
	private static int depositTotal;
	private static ArrayList<Integer> withdrawals = new ArrayList<>();
	private static int withdrawalTotal;
	private static JFrame frame;


	public ATM()
	{
		frame = new JFrame("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		new atmForm();
	}


	public static JFrame getFrame() {
		if (frame == null) {
			frame = new JFrame("ATM");
		}
		return frame;
	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ATM();
			}
		});
	}


	public static void deposit(double deposit)
	{
		deposits.add(deposit);
		depositTotal += deposit;

	}

	public static void withdraw(int withdrawal)
	{
		withdrawals.add(withdrawal);
		withdrawalTotal += withdrawal;
		atmBalance -= withdrawal;
	}

	public static void buyStamps(int num)
	{
		stampTotal -= num;
	}

	public static void emptyDeposits()
	{
		depositTotal = 0;
	}
	public static void clear()
	{
		deposits.clear();
		withdrawals.clear();
	}

	public static String viewLog()
	{
		String log = "Deposits                    Withdrawals\n";
		for(int i = 0; i < deposits.size(); i++)
		{
			log += deposits.get(i).toString() + "                                 " + withdrawals.get(i) + "\n";
			log += "Deposit total : $" + depositTotal + "              " + "Withdraw total: $" + withdrawalTotal;
		}

		return log;
	}

	public static void cashFill()
	{
		atmBalance = 10000;
	}

	public static void stampFill()
	{
		stampTotal = 4000;
	}

	public static String viewCS()
	{
		return "Cash: " + atmBalance + " " + "Stamps: " + stampTotal;
	}

	public static int getAtmBalance()
	{
		return atmBalance;
	}

	public static int getStampBalance()
	{
		return stampTotal;
	}
}
