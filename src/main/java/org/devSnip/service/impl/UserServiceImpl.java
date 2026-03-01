package org.devSnip.service.impl;


import lombok.RequiredArgsConstructor;

import org.devSnip.model.User;

import org.devSnip.repository.UserRepository;
import org.devSnip.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public List<User> viewAllUser() {
        return userRepository.viewAllUsers();
    }

    @Override
    public boolean updateUser(Integer id, User user) {
        return userRepository.updateUser(id, user);
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public boolean validateUser(User user) {

        User dbUser = userRepository.findByEmail(user.getEmail());

        if(dbUser == null) {
            return false;
        }

        return dbUser.getPassword().equals(user.getPassword());
    }
}
