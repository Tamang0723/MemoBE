package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.response.LoginMessage;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public interface UserService {



    String addUser(UserDTO userDTO);

    LoginResponse LoginUser(LoginDTO loginDTO);

}
