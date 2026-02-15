package org.devSnip.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.devSnip.dto.UserDto;
import org.devSnip.entity.User;
import org.devSnip.exception.ResourceNotFoundException;
import org.devSnip.repository.UserRepository;
import org.devSnip.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ObjectMapper mapper;

    @Override
    public void addUser(UserDto userDto) {
        User user = mapper.convertValue(userDto,User.class);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> viewAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList =new ArrayList<>();

        userList.forEach(entity ->{
            UserDto userDto = mapper.convertValue(entity, UserDto.class);
            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    @Override
    public UserDto viewUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("UserNot Found"));
        UserDto userDto = mapper.convertValue(user, UserDto.class);
        return userDto;
    }

    @Override
    public User updateUser(Integer id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("UserNot Found"));

        if (userDto.getName()!=null) user.setName(userDto.getName());
        if (userDto.getEmail()!=null) user.setEmail(userDto.getEmail());
        if (userDto.getPassword()!=null) user.setPassword(userDto.getPassword());
        if (userDto.getRole()!=null) user.setRole(userDto.getRole());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
