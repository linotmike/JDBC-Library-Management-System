package com.ps.data;

import com.ps.models.Patron;

import java.util.List;

public interface PatronDAOInt {
    List<Patron> getAllPatrons();
    List<Patron> getPatronsById(int patron_id);
    void addPatron(Patron patron);
    void updatePatron(Patron patron);
    void deletePatron(int patron);
}
