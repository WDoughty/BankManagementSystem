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
	private static ArrayList<Integer> deposits = new ArrayList<Integer>();
	private static int depositTotal;
	private static ArrayList<Integer> withdrawals = new ArrayList<Integer>();
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


	public static void deposit(int deposit)
	{
		deposits.add(deposit);
		depositTotal += deposit;

	}

	public void withdraw(int withdrawal)
	{
		withdrawals.add(withdrawal);
		withdrawalTotal += withdrawal;
		atmBalance -= withdrawal;
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
}
//	public boolean buyStamps(int numStamps)
//	{
//		if(numStamps <= stamps)
//		{
//			if (numStamps > 0 && numStamps % 1 == 0)
//			{
//				double total = numStamps * .55;
//
//				if (cusAcct.getBalance() >= total)
//				{
//					cusAcct.withdraw(total);
//					stamps -= numStamps;
//					return true;
//				}
//
//				else
//				{
//					System.out.println("Insufficient funds.");
//					return false;
//				}
//			}
//
//			else
//			{
//				System.out.println("Invalid number entered.");
//				return false;
//			}
//		}
//
//		else
//		{
//			System.out.println("Not enough stamps in machine. Please enter an amount lower than: " + stamps);
//			return false;
//		}
//	}

//	public void withdraw(int amount)
//	{
//		if (cusAcct.getBalance() >= amount)
//		{
//			if (amount % 20 == 0 && amount > 0)
//			{
//				if (amount <= atmBalance)
//				{
//					cusAcct.withdraw(amount);
//					atmBalance = atmBalance - amount;
//				}
//
//				else
//				{
//					System.out.println("Insufficient ATM balance. Please enter bank for withdrawal.");
//				}
//			}
//
//			else
//			{
//				System.out.println("Invalid number entered. Amount must be in multiples of 20 and greater than 0.");
//			}
//		}
//
//		else
//		{
//			System.out.println("Insufficient funds.");
//		}
//	}
