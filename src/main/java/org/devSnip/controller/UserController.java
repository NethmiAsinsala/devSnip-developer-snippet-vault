package org.devSnip.controller;

import lombok.RequiredArgsConstructor;

import org.devSnip.model.User;
import org.devSnip.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping ("/api/users")
public class UserController {
    private final UserService userService;

    @PostMapping ("/add")
    public boolean addUser(User user){
        return userService.addUser(user);
    }

    @GetMapping ("/get-all")
    public List<org.devSnip.model.User> viewAllUser(){
        return userService.viewAllUser();
    }

//    @GetMapping ("/view/{id}")
//    public UserDto viewUserById(@PathVariable Integer id){
//        return userService.viewUserById(id);
//    }
//
//    @PutMapping ("/update/{id}")
//    public void updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
//        userService.updateUser(id, userDto);
//    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteUser( Integer id){
        return userService.deleteUser(id);
    }
}
