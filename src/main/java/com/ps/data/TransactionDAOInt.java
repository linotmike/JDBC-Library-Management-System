package com.ps.data;

import com.ps.models.Transaction;

import java.util.List;

public interface TransactionDAOInt {
    void borrowBook(Transaction transaction);
    void returnBook(int transaction_id, String returnDate);
    List<Transaction> getAllTransaction();
    List<Transaction> getTransactionByPatron(int patron_id);
    List<Transaction> getTransactionByBook(int book_id);
    List<Transaction> getActiveTransaction ();
    List<Transaction> getOverDueTransactions(String currentDate, int overDueDate);


}
