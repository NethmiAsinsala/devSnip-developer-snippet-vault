package org.devSnip.service;

import jdk.dynalink.linker.LinkerServices;
import org.devSnip.dto.UserDto;
import org.devSnip.entity.User;

import java.util.List;

public interface UserService {
    void addUser(UserDto userDto);
    List<UserDto> viewAllUser();
    UserDto viewUserById(Integer id);
    User updateUser (Integer id , UserDto userDto);
    void deleteUser (Integer id);
}
