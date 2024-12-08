package com.ps.data;

import com.ps.models.Book;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAOInt {
    private final BasicDataSource basicDataSource;

    public BookDAOImpl(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";

        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery(query);
            while (resultSet.next()) {
                int book_id = resultSet.getInt("book_id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                int publishedYear = resultSet.getInt("published_year");
                int availableCopies = resultSet.getInt("available_copies");
                int library_id = resultSet.getInt("library_id");

                Book book = new Book(book_id,title,author,genre,publishedYear,availableCopies,library_id);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("No book found" + e.getMessage());
        }


        return books;
    }

    @Override
    public List<Book> getBookById(int book_id) {
        return List.of();
    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }
}
