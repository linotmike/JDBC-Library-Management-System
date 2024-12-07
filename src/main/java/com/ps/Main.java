package com.ps;

import com.ps.data.LibraryDAOImpl;
import com.ps.models.Library;
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

        List<Library> libraries = libraryDAOImpl.getAllLibraries();
        System.out.println(libraries);



    }
}