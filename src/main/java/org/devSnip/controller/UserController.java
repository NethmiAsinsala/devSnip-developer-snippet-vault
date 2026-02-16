package org.devSnip.controller;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.UserDatabase;
import org.devSnip.dto.UserDto;
import org.devSnip.entity.User;
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
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }

    @GetMapping ("/get-all")
    public List<UserDto> viewAllUser(){
        return userService.viewAllUser();
    }

    @GetMapping ("/view/{id}")
    public UserDto viewUserById(@PathVariable Integer id){
        return userService.viewUserById(id);
    }

    @PutMapping ("/update/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        userService.updateUser(id, userDto);
    }

    @DeleteMapping ("/delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }
}
