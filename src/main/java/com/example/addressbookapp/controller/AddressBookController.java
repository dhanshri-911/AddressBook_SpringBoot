package com.example.addressbookapp.controller;

import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.model.AddressBookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @GetMapping(value = {"/get"})
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        AddressBookData addressBookData = new AddressBookData(1,new AddressBookDTO("Dhanshri",
                "Zingade","888878678", "Dhanshr911@gmail.com","203,Sattaym",
                "Pune","Maharashtra",412307));
        ResponseDTO responseDTO = new ResponseDTO("Success Call!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    @GetMapping(value = {"/get/{personId}"})
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable int personId) {
        AddressBookData addressBookData = new AddressBookData(personId,new AddressBookDTO("Rajshri",
                "Zingade","777788899", "dhansh@gmail.com","navi mumbai ",
                "Navi Mumbai","Maharashtra",400701));
        ResponseDTO responseDTO = new ResponseDTO("Success Call for Person Id!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping(value = {"/adddata"})
    public ResponseEntity<ResponseDTO> addAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(2,addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data ADDED Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping(value = {"/edit/{personId}"})
    public ResponseEntity<ResponseDTO> editAddressBookData(@PathVariable int personId,
                                                           @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData = new AddressBookData(personId, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data UPDATED Successfully!!!",addressBookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/remove/{personId}"})
    public ResponseEntity<ResponseDTO> removeAddressBookData(@PathVariable int personId) {
        ResponseDTO responseDTO = new ResponseDTO("Data DELETED Successfully!!!",
                "ID number: "+personId + " DELETED!!!");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}


