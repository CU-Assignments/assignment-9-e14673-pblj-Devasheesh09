package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class BankingService {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    // Transfer money between accounts
    @Transactional(propagation = Propagation.REQUIRED)
    public void transferMoney(int fromAccountId, int toAccountId, double amount) throws Exception {
        Account fromAccount = accountDAO.getAccountById(fromAccountId);
        Account toAccount = accountDAO.getAccountById(toAccountId);

        if (fromAccount.getBalance() < amount) {
            throw new Exception("Insufficient funds for transfer.");
        }

        // Debit the amount from the sender account
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountDAO.updateAccount(fromAccount);

        // Credit the amount to the receiver account
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDAO.updateAccount(toAccount);

        // Record the transaction
        Transaction transaction = new Transaction(fromAccount, toAccount, amount);
        transactionDAO.saveTransaction(transaction);
    }
}
