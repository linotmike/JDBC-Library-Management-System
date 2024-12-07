package com.ps.models;

public class Transaction {
    private int transaction_id;
    private int book_id;
    private int patron_id;
    private String borrowDate;
    private String returnDate;

    public Transaction() {
    }

    public Transaction(int transaction_id, int book_id, int patron_id, String borrowDate, String returnDate) {
        this.transaction_id = transaction_id;
        this.book_id = book_id;
        this.patron_id = patron_id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getPatron_id() {
        return patron_id;
    }

    public void setPatron_id(int patron_id) {
        this.patron_id = patron_id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", book_id=" + book_id +
                ", patron_id=" + patron_id +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
