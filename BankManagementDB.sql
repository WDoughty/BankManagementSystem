CREATE DATABASE IF NOT EXISTS BankManagement;
USE BankManagement;

CREATE TABLE clients (
	client_number VARCHAR(50),
	client_name VARCHAR(100),
    client_password VARCHAR(100),
    email_address VARCHAR(50),
    PRIMARY KEY (client_number)
);

CREATE TABLE administrators (
	admin_number VARCHAR(50),
    admin_name VARCHAR(100),
    admin_password VARCHAR(100),
    PRIMARY KEY (admin_number)
);

CREATE TABLE employees (
	emp_number VARCHAR(50),
    emp_name VARCHAR(100),
    emp_password VARCHAR(100),
    emp_hours_worked DECIMAL(10,2),
    emp_pay DECIMAL(13, 2),
    employee_type VARCHAR(50),
    PRIMARY KEY (emp_number)
);

CREATE TABLE checking_accounts (
	chk_number VARCHAR(50),
    client_number VARCHAR(50),
    chk_balance DECIMAL(13, 2),
    PRIMARY KEY (chk_number),
    FOREIGN KEY (client_number)
		REFERENCES clients (client_number)
);

CREATE TABLE credit_accounts (
	crd_number VARCHAR(50),
    client_number VARCHAR(50),
    crd_balance DECIMAL(13, 2),
    crd_line DECIMAL(13, 2),
    crd_interst_rate DECIMAL(13, 2),
    PRIMARY KEY (crd_number),
    FOREIGN KEY (client_number)
		REFERENCES clients (client_number)
);

CREATE TABLE loan_accounts (
	loan_number VARCHAR(50),
    client_number VARCHAR(50),
    loan_balance DECIMAL(13, 2),
    loan_interest_rate DECIMAL(13, 2),
    PRIMARY KEY (loan_number),
    FOREIGN KEY (client_number)
		REFERENCES clients (client_number)
);

CREATE TABLE shifts (
	shift_id VARCHAR(50),
	emp_number VARCHAR(50),
    start_time DATETIME,
    end_time DATETIME,
    PRIMARY KEY (shift_id),
    FOREIGN KEY (emp_number)
		REFERENCES employees (emp_number)
);

CREATE TABLE transactions (
	transaction_id VARCHAR(50),
    client_number VARCHAR(50),
    account_number VARCHAR(50),
    transaction_type VARCHAR(50),
    transaction_amount DECIMAL(13, 2),
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (client_number)
		REFERENCES clients (client_number)
);

CREATE TABLE brokerage_accounts(
    brk_number VARCHAR(50),
    client_number VARCHAR(50),
    stock_abbrv VARCHAR(10),
    stock_amount DECIMAL(50,0),
    PRIMARY KEY (brk_number),
    FOREIGN KEY (client_number)
        REFERENCES clients (client_number)
);

CREATE TABLE customer_messages(
	msg_number VARCHAR(50),
    msg_subject VARCHAR(100),
    msg_email VARCHAR(50),
    msg_body VARCHAR(1000),
    PRIMARY KEY (msg_number)
);

CREATE TABLE appointments(
	apt_number VARCHAR(50),
    apt_name VARCHAR(50),
    apt_time VARCHAR(50),
    apt_date VARCHAR(50),
    PRIMARY KEY (apt_number)
);
    