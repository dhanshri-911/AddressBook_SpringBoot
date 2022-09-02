package com.example.addressbookapp.service;

import com.example.addressbookapp.dto.LoginDTO;
import com.example.addressbookapp.dto.UserDTO;
import com.example.addressbookapp.model.User;

import java.util.List;

public interface IUserService {
        String loginUser(LoginDTO loginDTO);

        List<User> getUserInfo();

        com.example.addressbookapp.model.User registerUser(UserDTO userDTO);
    }
