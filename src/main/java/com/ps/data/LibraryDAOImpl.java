package com.ps.data;

import com.ps.models.Library;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;



public class LibraryDAOImpl implements LibraryDAOInt {
    private DataSource dataSource;
//    private static final Logger logger = Logger.getLogger(LibraryDAOImpl.class.getName());

    public LibraryDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Library> getAllLibraries() {
        List<Library> libraries = new ArrayList<>();
        String query = "SELECT * FROM library";
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               int library_id = resultSet.getInt("library_id");
               String name = resultSet.getString("name");
               String address = resultSet.getString("address");
               String phone = resultSet.getString("phone");

               Library library = new Library(library_id,name,address,phone);
               libraries.add(library);
            }
            if(libraries.isEmpty()){
                System.out.println("No libraries found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }

    @Override
    public List<Library> getLibraryById(int library_id) {
        return List.of();
    }

    @Override
    public void addLibrary(Library library) {

    }

    @Override
    public void updateLibrary(Library library) {

    }

    @Override
    public void deleteLibrary(int library_id) {

    }
}