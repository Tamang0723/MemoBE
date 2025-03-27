package com.example.RegisterLogin.Service.impl;

import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Repo.UserRepo;
import com.example.RegisterLogin.Service.UserService;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUserid(), userDTO.getUsername(), userDTO.getEmail(), this.passwordEncoder.encode(userDTO.getPassword()),userDTO.getCourse());
        userRepo.save(user);

        return user.getUsername();
    }

    @Override
    public LoginResponse LoginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if (user !=null) {
            String password =loginDTO.getPassword();
            String encodePassword =  user.getPassword();
            boolean isPwdRight = passwordEncoder.matches(password,encodePassword);
            if (isPwdRight){
               // Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(),encodePassword);

                            return new LoginResponse("Login Success", true);
                        }else{
                            return new LoginResponse("Login Failed", false);
                        }
            }else{
                return new LoginResponse("password Not Match", false);
            }

        }

//        else{
//            return new LoginResponse("Email not exits", false);
//        }

}
