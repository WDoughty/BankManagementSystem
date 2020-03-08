# BankManagementSystem

## Inception Paragraph
A company wants to develop an electronic Bank Management System that allows 
clients to store money in their respective accounts. All types of users should be able to login in to their accounts. Employees should be able to add accounts, delete accounts, deposit funds, withdraw funds, check balances, calculate interest,
and transfer funds for clients. HR should be able to schedule shifts for employees.

## DATABASE CHANGED
Get accounts and get users now searchs database based on client number only. This will allow us to return all accounts associated with user.

The Database creation sql script has been updated. To update existing db add transactions table. Also make sure email_address and employee_type have been added to clients and employees respectively.
  
  
 ## Use Cases
Iteration 1 
 Add Funds
 Withdraw Funds
 Create Account 
 Delete Account
 Create Client 
 Check Balance
 
 Need harder use cases. 
 Hr-> Time clock system for employees, Paycheck 
 Interest on accounts
 Selling postage in ATM etc.
 
Iteration 2-3
 Calculate Interest
 Print Receipt 
 Transfer Funds
 
 ## INSTALL MYSQL STUFF
 Download the mysql installer from here https://dev.mysql.com/downloads/installer/. Run it and install mysql server and mysql workbench. Set user name to 'root' and password to 'Password'.
 Download the mysql connector from here https://dev.mysql.com/downloads/connector/j/. Select platform independent. Extract the file. Add the Jar to the external libraries in your ide.
 
 ## SQL Tables
 Tables created with DECIMAL types are set as DECIMAL(10,0). Change those to DECIMAL(13,2). If you already created the database you can
 Change it by running the command on the mysql client: ALTER TABLE name_of_table MODIFY COLUMN name_of_column DECIMAL(13,2);
 

 
  
