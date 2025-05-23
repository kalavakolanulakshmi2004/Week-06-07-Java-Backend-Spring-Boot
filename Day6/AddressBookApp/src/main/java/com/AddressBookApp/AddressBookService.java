package com.AddressBookApp;


import java.util.List;

public interface AddressBookService {
    List<AddressBook> getAll();
    AddressBook getById(int id);
    AddressBook create(AddressBookDTO dto);
    AddressBook update(int id, AddressBookDTO dto);
    void delete(int id);
}
