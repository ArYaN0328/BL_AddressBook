package com.example.addressBookapp.services;


import com.example.addressBookapp.dto.AddressBookDto;
import com.example.addressBookapp.model.AddressBook;
import com.example.addressBookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    AddressBookRepository addressBookRepository;

    public List<AddressBook> getall()
    {
        return addressBookRepository.findAll();
    }

    public AddressBook getByid(Long id)
    {
        return addressBookRepository.findById(id).orElseThrow(()->new RuntimeException("No data found"));
    }

    public AddressBook postAddress(AddressBookDto address)
    {
        AddressBook ad=new AddressBook();
        ad.setCity(address.getCity());
        ad.setName(address.getName());
        ad.setState(address.getState());
        ad.setPhoneNumber(address.getPhoneNumber());
        return addressBookRepository.save(ad);
    }

  public AddressBook putAddress(Long id,AddressBookDto address)
  {
      Optional<AddressBook> existed=addressBookRepository.findById(id);
      if(existed.isPresent())
      {
          AddressBook ad= existed.get();
          ad.setCity(address.getCity());
          ad.setName(address.getName());
          ad.setState(address.getState());
          ad.setPhoneNumber(address.getPhoneNumber());
          return addressBookRepository.save(ad);
      }
      return null;

  }

  public void DeleteByid(Long id)
  {
      addressBookRepository.deleteById(id);
  }


}
