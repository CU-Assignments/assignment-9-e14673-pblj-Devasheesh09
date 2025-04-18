CREATE DATABASE banking_system;

USE banking_system;

CREATE TABLE account (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_holder VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

CREATE TABLE transaction (
    id INT AUTO_INCREMENT PRIMARY KEY,
    from_account_id INT,
    to_account_id INT,
    amount DOUBLE,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (from_account_id) REFERENCES account(id),
    FOREIGN KEY (to_account_id) REFERENCES account(id)
);
