package com.example.addressbookapp.controller;
import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.dto.LoginDTO;
import com.example.addressbookapp.dto.ResponseDTO;
import com.example.addressbookapp.dto.UserDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.model.User;
import com.example.addressbookapp.service.IUserService;
import com.example.addressbookapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserService IUserService;


    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        //log.info("inside userLogin Controller Method");
        ResponseDTO responseDTO = new ResponseDTO("User Logged In Successfully!!!", IUserService.loginUser(loginDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    @PostMapping(value = {"/register"})
    public User registerUser(@RequestBody UserDTO userDTO) {
        return IUserService.registerUser(userDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getUserInfo() {
        List<User> userList = IUserService.getUserInfo();
        ResponseDTO responseDTO = new ResponseDTO("Getting User Info ", userList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}