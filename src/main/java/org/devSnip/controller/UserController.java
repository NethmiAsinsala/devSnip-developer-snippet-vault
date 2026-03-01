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


    @PatchMapping ("/update/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteUser( @PathVariable Integer id){
        return userService.deleteUser(id);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user) {
        return userService.validateUser(user);
    }
}
