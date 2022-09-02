package com.example.addressbookapp.service;
import com.example.addressbookapp.dto.AddressBookDTO;
import com.example.addressbookapp.model.AddressBookData;
import com.example.addressbookapp.model.User;
import com.example.addressbookapp.util.TokenUtil;
import com.example.addressbookapp.dto.LoginDTO;
import com.example.addressbookapp.dto.UserDTO;
import com.example.addressbookapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserService implements IUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    UserRepository userRepository;



    @Override
    public String loginUser(LoginDTO loginDTO) {

        User userLogin =userRepository.findByEmailId(loginDTO.emailId);

        if (userLogin == null)
            return "User not found";

        if (!(bCryptPasswordEncoder.matches(loginDTO.password, userLogin.getPassword())))
            return "User name or password incorrect";

        String token = tokenUtil.createToken(userLogin.getUser_Id());
        log.info("LoginUser Service Method Successfully executed");

        return token;
    }

    @Override
    public User registerUser(UserDTO userDTO) {
        String encodedPassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encodedPassword);
        User user = new User(encodedPassword,userDTO.userName,userDTO.emailId);
       return userRepository.save(user);
    }


    @Override
    public List<User> getUserInfo() {
        log.info("getUserInfo Service Method Successfully executed");
        return userRepository.findAll() ;
    }

}
