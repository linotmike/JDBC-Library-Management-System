package com.ps;

import com.ps.data.BookDAOImpl;
import com.ps.data.LibraryDAOImpl;
import com.ps.data.PatronDAOImpl;
import com.ps.models.Book;
import com.ps.models.Library;
import com.ps.models.Patron;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello, World!");
        if (args.length != 2){
            System.out.println("Application needs two arguments to run");
            System.exit(1);
        }
        String userName = args[0];
        String password = args[1];

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/library_db");

        LibraryDAOImpl libraryDAOImpl = new LibraryDAOImpl(basicDataSource);

//        List<Library> libraries = libraryDAOImpl.getAllLibraries();
//        System.out.println(libraries);
//        List<Library> getLibraryById = libraryDAOImpl.getLibraryById(1);
//        System.out.println(getLibraryById);

//        Library library = new Library(1,"Gamo gofa city library","312 bole st","123456789");
//////        libraryDAOImpl.addLibrary(library);
//        libraryDAOImpl.updateLibrary(library);
//        System.out.println(library);

//        libraryDAOImpl.deleteLibrary(5);

        BookDAOImpl bookDAOImpl = new BookDAOImpl(basicDataSource);
//        List<Book>books = bookDAOImpl.getAllBook();
//        bookDAOImpl.getAllBook();
//        List<Book> books = bookDAOImpl.getBookById(1);
//        Book books = new Book(5,"The book of ethiopia","Lino the goat","non-fiction",2001,31,1);
//        bookDAOImpl.addBook(books);
//        bookDAOImpl.updateBook(books);
//        bookDAOImpl.deleteBook(5);
//        System.out.println(books);

        PatronDAOImpl patronDAOImpl = new PatronDAOImpl(basicDataSource);
//        List<Patron>patrons = patronDAOImpl.getAllPatrons();
//        List<Patron> patrons = patronDAOImpl.getPatronsById(1);
//        Patron patrons = new Patron(4,"salsawit ssmiel","emiailai.email.com","1234567");
//        patronDAOImpl.addPatron(patrons);
//        patronDAOImpl.updatePatron(patrons);
        patronDAOImpl.deletePatron(4);
//        System.out.println(patrons);
    }
}