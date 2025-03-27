package com.example.RegisterLogin.Controller;


import com.example.RegisterLogin.Dto.LoginDTO;
import com.example.RegisterLogin.Dto.UserDTO;
import com.example.RegisterLogin.Entity.User;
import com.example.RegisterLogin.Repo.UserRepo;
import com.example.RegisterLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    private UserRepo userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path = "save")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }

//    @PostMapping(path ="/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
//    {
//        LoginResponse loginResponse = userService.LoginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Email does not exist"));
        }

        // Compare hashed password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("message", "Incorrect Email and Password"));
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message","Login Success");
        response.put("course",user.getCourse());

        return ResponseEntity.ok(response);
    }

}
