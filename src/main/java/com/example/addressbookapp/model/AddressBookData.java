package com.example.addressbookapp.model;


import com.example.addressbookapp.dto.AddressBookDTO;
import lombok.Data;

import javax.persistence.*;

@Data                           // Lombak library for getters and setters...
 @Entity
 @Table(name = "address_book")

//Added Lombok Library for setter getter

    public class AddressBookData {
     @Id
     @GeneratedValue
     @Column(name = "id")
    // private int personId;
     private int id;
     private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zip;
//    private String password;
//    private String username;


    public AddressBookData() {
    }


//    public AddressBookData(AddressBookDTO addressBookDTO) {
//        this.firstName = addressBookDTO.firstName;
//        this.lastName = addressBookDTO.lastName;
//        this.phoneNumber = addressBookDTO.phoneNumber;
//        this.email = addressBookDTO.email;
//        this.address = addressBookDTO.address;
//        this.city = addressBookDTO.city;
//        this.state = addressBookDTO.state;
//        this.zip = addressBookDTO.zip;
//    }

    public void updateData(AddressBookDTO addressBookDTO) {
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.phoneNumber = addressBookDTO.phoneNumber;
        this.email = addressBookDTO.email;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zip = addressBookDTO.zip;
    }
}
