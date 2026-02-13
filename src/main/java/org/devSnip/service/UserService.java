package org.devSnip.service;

import org.devSnip.dto.UserDto;
import org.devSnip.model.User;

import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    List<UserDto> viewAllUser();
    UserDto viewUserById(Integer id);
    User updateUser (Integer id , UserDto userDto);
    void deleteUser (Integer id);
}
