package com.example.addressbook3.repository;

import com.example.addressbook3.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {
}

