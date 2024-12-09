package com.ps.data;

import com.ps.models.Transaction;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAOInt {
private final BasicDataSource basicDataSource;
public TransactionDAOImpl(BasicDataSource basicDataSource){
    this.basicDataSource = basicDataSource;
}
    @Override
    public void borrowBook(Transaction transaction) {

    }

    @Override
    public void returnBook(int transaction_id, String returnDate) {

    }

    @Override
    public List<Transaction> getAllTransaction() {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction";
        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int transaction_id = resultSet.getInt("transaction_id");
                int book_id = resultSet.getInt("book_id");
                int patron_id = resultSet.getInt("patron_id");
                String borrowDate = resultSet.getString("borrow_Date");
                String returnDate = resultSet.getString("return_date");

                Transaction transaction = new Transaction(transaction_id,book_id,patron_id,borrowDate,returnDate);
                transactions.add(transaction);


            }
        } catch (SQLException e) {
            System.out.println("Error could not get transaction from database" + e.getMessage());

        }
        return transactions;
    }

    @Override
    public List<Transaction> getTransactionByPatron(int patron_id) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionByBook(int book_id) {
        return List.of();
    }

    @Override
    public List<Transaction> getActiveTransaction() {
        return List.of();
    }

    @Override
    public List<Transaction> getOverDueTransactions(String currentDate, int overDueDate) {
        return List.of();
    }
}
