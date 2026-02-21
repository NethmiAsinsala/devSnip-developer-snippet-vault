package org.devSnip.service;


import org.devSnip.model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> viewAllUser();
//    UserDto viewUserById(Integer id);
//    User updateUser (Integer id , UserDto userDto);
    boolean deleteUser (Integer id);
}
