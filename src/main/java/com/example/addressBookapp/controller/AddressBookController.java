package com.example.addressBookapp.controller;

import com.example.addressBookapp.dto.AddressBookDto;
import com.example.addressBookapp.model.AddressBook;
import com.example.addressBookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public AddressBook getbyId(@PathVariable Long id)
    {
        return addressBookrepository.findById(id).orElseThrow(()->new RuntimeException(("No one found")));
    }

    @PostMapping()
    public AddressBook postAddress(@RequestBody AddressBookDto address)
    {
        AddressBook ad=new AddressBook();
        ad.setCity(address.getCity());
        ad.setName(address.getName());
        ad.setState(address.getState());
        ad.setPhoneNumber(address.getPhoneNumber());
        return addressBookrepository.save(ad);
    }
    @PutMapping("/{id}")
    public AddressBook putAddress(@PathVariable Long id,@RequestBody AddressBookDto address)
    {
        Optional<AddressBook> existed=addressBookrepository.findById(id);
        if(existed.isPresent())
        {
            AddressBook ad= existed.get();
            ad.setCity(address.getCity());
            ad.setName(address.getName());
            ad.setState(address.getState());
            ad.setPhoneNumber(address.getPhoneNumber());
            return addressBookrepository.save(ad);
        }
        return null;


    }
    @DeleteMapping("/{id}")
    public void deletebyid(@PathVariable Long id)
    {
        addressBookrepository.deleteById(id);
    }

}
