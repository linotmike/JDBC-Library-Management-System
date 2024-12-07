package com.ps.data;

import com.ps.models.Library;

import java.util.List;

public interface LibraryDAOInt {
    List<Library> getAllLibraries();
    List<Library> getLibraryById(int library_id);
    void addLibrary(Library library);
    void updateLibrary(Library library);
    void deleteLibrary(int library_id);
}
