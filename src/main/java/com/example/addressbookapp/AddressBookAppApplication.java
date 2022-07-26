package com.example.addressbookapp;

import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
//@Enabledsw

public class AddressBookAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Address Book Application Started!!!");
        System.out.println("Welcome to Address Book Program");
    }
//@Bean
// public ModelMapper modelMapper(){
//        return new ModelMapper();
//}
}
