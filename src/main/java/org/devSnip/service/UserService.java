package org.devSnip.service;


import org.devSnip.model.User;

import java.util.List;

public interface UserService {
    boolean addUser(User user);
    List<User> viewAllUser();
    boolean updateUser (Integer id , User user);
    boolean deleteUser (Integer id);
}
