package com.example.addressbookapp.model;
import com.example.addressbookapp.dto.LoginDTO;
import com.example.addressbookapp.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

    @Data
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name="user")
    public class User {

        @Id
        @GeneratedValue
        @Column(name = "user_id", nullable = false)
        private Long user_Id;


        private String userName;
        private String emailId;
        private String password;

        public User(String encodedPassword, String userName,  String emailId) {
            this.password = encodedPassword;
            this.userName = userName;
            this.emailId = emailId;
        }


        public Long getUser_Id() {
            return user_Id;
        }

        public String getPassword() {
            return password;
        }

        public void setUser_Id(Long user_Id) {
            this.user_Id = user_Id;
        }

        public User(UserDTO UserDTO) {

            this.userName = UserDTO.userName;
            this.emailId = UserDTO.emailId;
            this.password = UserDTO.password;
        }

        public User(LoginDTO loginDTO) {
            this.emailId = loginDTO.emailId;
            this.password = loginDTO.password;
        }
    }