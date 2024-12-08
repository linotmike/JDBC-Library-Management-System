package com.ps.data;

import com.ps.models.Patron;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatronDAOImpl implements PatronDAOInt {
    private final BasicDataSource basicDataSource;

    public PatronDAOImpl(BasicDataSource basicDataSource){
        this.basicDataSource = basicDataSource;
    }
    @Override
    public List<Patron> getAllPatrons() {
        List<Patron> patrons = new ArrayList<>();
        String query = "SELECT * FROM patron ";
        try (
                Connection connection = this.basicDataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Patron patron = mapPatrons(resultSet);
                patrons.add(patron);
            }
        } catch (SQLException e) {
            System.out.println("Error fetching all patrons from the database " + e.getMessage());
        }
        return patrons;
    }

    @Override
    public List<Patron> getPatronsById(int patron_id) {
        return List.of();
    }

    @Override
    public void addPatron(Patron patron) {

    }

    @Override
    public void updatePatron(Patron patron) {

    }

    @Override
    public void deletePatron(int patron) {

    }

    public Patron mapPatrons (ResultSet resultSet) throws SQLException {
       int patron_id = resultSet.getInt("patron_id");
        String name = resultSet.getString("name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");

        return new Patron(patron_id,name,email,phone);
    }
}
