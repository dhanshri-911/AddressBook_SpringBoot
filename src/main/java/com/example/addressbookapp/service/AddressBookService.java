package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressBookService {
    public List<AddressBookData> getAddressBookData() {
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        addressBookDataList.add(new AddressBookData(1, new AddressBookDTO("Dhanshri",
                "Zingade", "885654344", "dhanshri@gmail.com", "203 sattyam",
                "Navi mumbai", "Maharashtra", 400354)));
        return addressBookDataList;
    }

    public AddressBookData getAddressBookById(int personId) {
        AddressBookData addressBookData = new AddressBookData(personId, new AddressBookDTO("Dhanshri",
                "Zingade", "885654344", "dhanshri@gmail.com", "203 sattyam",
                "Navi mumbai", "Maharashtra", 400354));
        return addressBookData;
    }

    public AddressBookData addAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(1, addressBookDTO);
        return addressBookData;
    }

    public AddressBookData editAddressBookData(int personId, AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(personId, addressBookDTO);
        return addressBookData;
    }

    public void deleteAddressBookData(int personId) {

    }

}
