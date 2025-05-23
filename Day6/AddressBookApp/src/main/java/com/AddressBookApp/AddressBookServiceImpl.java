package com.AddressBookApp;


import org.springframework.stereotype.Service;

import java.util.*;
        import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AddressBookServiceImpl implements AddressBookService {
    private final List<AddressBook> addressList = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    public List<AddressBook> getAll() {
        return addressList;
    }

    public AddressBook getById(int id) {
        return addressList.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElseThrow(() -> new AddressBookException("Address not found"));
    }

    public AddressBook create(AddressBookDTO dto) {
        AddressBook address = new AddressBook();
        address.setId(idCounter.incrementAndGet());
        address.setName(dto.getName());
        address.setCity(dto.getCity());
        addressList.add(address);
        return address;
    }

    public AddressBook update(int id, AddressBookDTO dto) {
        AddressBook address = getById(id);
        address.setName(dto.getName());
        address.setCity(dto.getCity());
        return address;
    }

    public void delete(int id) {
        AddressBook address = getById(id);
        addressList.remove(address);
    }
}
