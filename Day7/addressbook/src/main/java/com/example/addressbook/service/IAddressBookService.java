package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookModel;

import java.util.List;

public interface IAddressBookService {
    List<AddressBookModel> getAllContacts();
    AddressBookModel getContactById(int id);
    AddressBookModel addContact(AddressBookDTO dto);
    AddressBookModel updateContact(int id, AddressBookDTO dto);
    void deleteContact(int id);
}
