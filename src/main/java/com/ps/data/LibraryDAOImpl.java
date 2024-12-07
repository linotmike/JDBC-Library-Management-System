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
            while (resultSet.next()) {
                Library library = mapLibraries(resultSet);
                libraries.add(library);
            }
            if (libraries.isEmpty()) {
                System.out.println("No libraries found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }

    @Override
    public List<Library> getLibraryById(int library_id) {
        List<Library> libraries = new ArrayList<>();
        String query = "SELECT * FROM library WHERE library_id=?";
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, library_id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();
            ) {
                if (resultSet.next()) {
                    Library library = mapLibraries(resultSet);
                    libraries.add(library);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }

    @Override
    public void addLibrary(Library library) {
        String query = "INSERT INTO library (library_id,name,address,phone) VALUES (?,?,?,?)";
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
            setLibraryParameters(preparedStatement,library);

            int rowsCreated = preparedStatement.executeUpdate();

            if(rowsCreated > 0){
                System.out.println("Rows created " + rowsCreated);
            }else{
                System.out.println("No rows created");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateLibrary(Library library) {

    }

    @Override
    public void deleteLibrary(int library_id) {

    }

    public Library mapLibraries(ResultSet resultSet) throws SQLException {
        int library_id = resultSet.getInt("library_id");
        String name = resultSet.getString("name");
        String address = resultSet.getString("address");
        String phone = resultSet.getString("phone");

        return new Library(library_id, name, address, phone);
    }

    public void setLibraryParameters(PreparedStatement preparedStatement, Library library) throws SQLException{
        preparedStatement.setInt(1,library.getLibrary_id());
        preparedStatement.setString(2, library.getName());
        preparedStatement.setString(3, library.getAddress());
        preparedStatement.setString(4, library.getPhone());
    }

}
