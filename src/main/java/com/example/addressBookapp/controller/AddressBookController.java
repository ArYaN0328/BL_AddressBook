package com.example.addressBookapp.controller;

import com.example.addressBookapp.model.AddressBook;
import com.example.addressBookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookrepository;

    @GetMapping
    public List<AddressBook> getall()
    {
        return addressBookrepository.findAll();
    }
    @PostMapping()
    public AddressBook postAddress(@RequestBody  AddressBook address)
    {
        return addressBookrepository.save(address);
    }

}
