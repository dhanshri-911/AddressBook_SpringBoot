package com.example.addressbookapp.repository;

import com.example.addressbookapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    //@Query(value = "select *from user_registration where email_id = :emailId", nativeQuery = true)
  //  List<User> findByEmailId(String emailId);

    //Optional<User> findByEmailIdAndPassword(String emailId, String password);

    User findByEmailId(String emailId);

}
