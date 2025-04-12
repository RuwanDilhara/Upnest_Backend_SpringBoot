package org.icet.upnest.controller;

import lombok.RequiredArgsConstructor;
import org.icet.upnest.dto.User;
import org.icet.upnest.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    final UserService service;

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user){
        return service.register(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
        return service.verify(user);
    }
}
