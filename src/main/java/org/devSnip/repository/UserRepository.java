package org.devSnip.repository;

import org.devSnip.model.Folder;
import org.devSnip.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    boolean addUser(User user);
    boolean deleteUser(Integer id);
    boolean updateUser(Integer id, User user);
    List<User> viewAllUsers();
}
