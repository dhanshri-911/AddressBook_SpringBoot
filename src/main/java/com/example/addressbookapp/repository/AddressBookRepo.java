package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressBookRepo extends JpaRepository<AddressBookData,Integer> {
    @Query(value = "select *from address_book order by city", nativeQuery = true)
    List<AddressBookData> findContactsByCity();
    @Query (value = "select *from address_book order by state", nativeQuery = true)
    List<AddressBookData> findContactsByState();

}
