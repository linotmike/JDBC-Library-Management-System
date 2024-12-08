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
                Book book = mapBooks(resultSet);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("No book found" + e.getMessage());
        }


        return books;
    }

    @Override
    public List<Book> getBookById(int book_id) {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book WHERE book_id = ?";
        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, book_id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                if (resultSet.next()) {
                    Book book = mapBooks(resultSet);
                    books.add(book);
                }
            }
        } catch (SQLException e) {
            System.out.println("No books found with that id" + e.getMessage());
        }
        return books;
    }

    @Override
    public void addBook(Book book) {
        String query = "INSERT INTO book (book_id,title,author,genre,published_year,available_copies,library_id) VALUES (?,?,?,?,?,?,?)";
        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
            preparedStatement.setInt(1,book.getBook_id());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setString(4,book.getGenre());
            preparedStatement.setInt(5,book.getPublishedYear());
            preparedStatement.setInt(6,book.getAvailableCopies());
            preparedStatement.setInt(7,book.getLibrary_id());

            int rowsAdded = preparedStatement.executeUpdate();
            if(rowsAdded > 0){
                System.out.println("Rows added" + rowsAdded);
            }else{
                System.out.println("No rows added");
            }
        } catch (SQLException e) {
            System.out.println("Error adding book to the database" + e.getMessage());
        }

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }

    public Book mapBooks(ResultSet resultSet) throws SQLException {
        int book_id = resultSet.getInt("book_id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String genre = resultSet.getString("genre");
        int publishedYear = resultSet.getInt("published_year");
        int availableCopies = resultSet.getInt("available_copies");
        int library_id = resultSet.getInt("library_id");

        return new Book(book_id, title, author, genre, publishedYear, availableCopies, library_id);


    }
}
