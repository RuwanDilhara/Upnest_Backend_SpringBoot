package org.icet.upnest.controller;

import org.icet.upnest.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class LoginController {

    List<User> studentList = new ArrayList<>(Arrays.asList(
            new User(1,"Ruwan Dilhara","1234"),
            new User(2,"Kavindu Akalanka","1234")

    ));

    @GetMapping("/students")
    public List<User> getString(){
        return studentList;
    }

    @PostMapping("/addStudent")
    public User addStudent(@RequestBody User student){
        studentList.add(student);
        return student;
    }
}
