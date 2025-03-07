package com.example.addressBookapp.controller;

import com.example.addressBookapp.dto.AddressBookDto;
import com.example.addressBookapp.model.AddressBook;
import com.example.addressBookapp.repository.AddressBookRepository;
import com.example.addressBookapp.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    AddressBookRepository addressBookrepository;
    @Autowired
    AddressBookService addressBookService;

    @GetMapping
    public List<AddressBook> getall()
    {
   return addressBookService.getall();
    }






    @GetMapping("/{id}")
    public AddressBook getbyId(@PathVariable Long id)
    {
       return addressBookService.getByid(id);
    }

    @PostMapping()
    public AddressBook postAddress(@RequestBody AddressBookDto address)
    {
     return addressBookService.postAddress(address);
    }
    @PutMapping("/{id}")
    public AddressBook putAddress(@PathVariable Long id,@RequestBody AddressBookDto address)
    {
     return addressBookService.putAddress(id,address);

    }
    @DeleteMapping("/{id}")
    public void deletebyid(@PathVariable Long id)
    {
       addressBookService.DeleteByid(id);
    }

}
