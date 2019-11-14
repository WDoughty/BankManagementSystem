package ATM;

import Account.*;
import Database.Database;
import User.*;
import GUI.*;
import javax.swing.*;
import java.awt.*;

import java.awt.*;

public class ATM
{
	private Database db;
	private int stamps = 4000;
	private int atmBalance = 10000;
	private static JFrame frame;



	public ATM(){
		frame = new JFrame("ATM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		new atmForm();
	}


	public static JFrame getFrame(){
		if(frame == null){
			frame = new JFrame("ATM");
		}
		return frame;
	}

	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ATM();
			}
		});
	}
	public boolean buyStamps(int numStamps)
	{
		if(numStamps <= stamps)
		{
			if (numStamps > 0 && numStamps % 1 == 0)
			{
				double total = numStamps * .55;

				if (cusAcct.getBalance() >= total)
				{
					cusAcct.withdraw(total);
					stamps -= numStamps;
					return true;
				}

				else
				{
					System.out.println("Insufficient funds.");
					return false;
				}
			}

			else
			{
				System.out.println("Invalid number entered.");
				return false;
			}
		}

		else
		{
			System.out.println("Not enough stamps in machine. Please enter an amount lower than: " + stamps);
			return false;
		}
	}

	public void withdraw(int amount)
	{
		if (cusAcct.getBalance() >= amount)
		{
			if (amount % 20 == 0 && amount > 0)
			{
				if (amount <= atmBalance)
				{
					cusAcct.withdraw(amount);
					atmBalance = atmBalance - amount;
				}

				else
				{
					System.out.println("Insufficient ATM balance. Please enter bank for withdrawal.");
				}
			}

			else
			{
				System.out.println("Invalid number entered. Amount must be in multiples of 20 and greater than 0.");
			}
		}

		else
		{
			System.out.println("Insufficient funds.");
		}
	}
}
