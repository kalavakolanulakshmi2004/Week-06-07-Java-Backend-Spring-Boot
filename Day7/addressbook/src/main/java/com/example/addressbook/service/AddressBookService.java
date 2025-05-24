package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookModel;
import com.example.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    private AddressBookRepository repository;

    @Override
    public List<AddressBookModel> getAllContacts() {
        return repository.findAll();
    }

    @Override
    public AddressBookModel getContactById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public AddressBookModel addContact(AddressBookDTO dto) {
        return repository.save(new AddressBookModel(dto.getName(), dto.getAddress()));
    }

    @Override
    public AddressBookModel updateContact(int id, AddressBookDTO dto) {
        AddressBookModel existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(dto.getName());
            existing.setAddress(dto.getAddress());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteContact(int id) {
        repository.deleteById(id);
    }
}
