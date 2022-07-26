package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.exception.AddressBookException;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.repository.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService {

    @Autowired
    AddressBookRepo addressBookRepo;

    public List<AddressBookData> getAddressBookData() {
        return addressBookRepo.findAll();
    }

    public AddressBookData getAddressBookById(int personId) {
        return addressBookRepo.findById(personId)
                .orElseThrow(() -> new AddressBookException("Address Book Contact Id not Found!!!"));
    }

    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(addressBookDTO);
        addressBookRepo.save(addressBookData);
        return addressBookData;
    }

    public AddressBookData editAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookData.updateData(addressBookDTO);
        return addressBookRepo.save(addressBookData);
    }

    public void deleteAddressBookData(int personId) {
        AddressBookData addressBookData = this.getAddressBookById(personId);
        addressBookRepo.delete(addressBookData);
    }
    public List<AddressBookData> getContactsByCity() {
        return addressBookRepo.findContactsByCity();
    }

    public List<AddressBookData> getContactsByState() {
        return addressBookRepo.findContactsByState();
    }

}
