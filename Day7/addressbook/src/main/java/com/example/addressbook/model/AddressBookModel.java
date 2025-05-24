package com.example.addressbook.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;

    public AddressBookModel() {}

    public AddressBookModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
}
