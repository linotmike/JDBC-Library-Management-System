package com.ps.models;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private String genre;
    private int publishedYear;
    private int availableCopies;
    private int library_id;

    public Book() {
    }

    public Book(int book_id, String title, String author, String genre, int publishedYear, int availableCopies, int library_id) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publishedYear = publishedYear;
        this.availableCopies = availableCopies;
        this.library_id = library_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nbook_id=" + book_id +
                "\n, title='" + title + '\'' +
                "\n, author='" + author + '\'' +
                "\n, genre='" + genre + '\'' +
                "\n, publishedYear=" + publishedYear +
                "\n, availableCopies=" + availableCopies +
                "\n, library_id=" + library_id +
                '}';
    }
}
