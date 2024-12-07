package com.ps.data;

import com.ps.models.Library;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDAOImpl implements LibraryDAOInt {
    private DataSource dataSource;

    public LibraryDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Library> getAllLibraries() {
        return List.of();
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
