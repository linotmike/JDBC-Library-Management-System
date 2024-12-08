package com.ps.data;

import com.ps.models.Book;

import java.util.List;

public interface BookDAOInt {
    List<Book> getAllBook();
    List<Book>getBookById(int book_id);
    void addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);
}
