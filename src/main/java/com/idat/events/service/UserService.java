package com.idat.events.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.events.model.User;
import com.idat.events.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }               

    public boolean exists(String email) {   
        return userRepository.existsByEmail(email);
    }

    public User updateUserById(Long id, User updatedUser) {
        User userExist = userRepository.findById(id).orElse(null);

        if (userExist != null) {
            userExist.setName(updatedUser.getName());
            userExist.setEmail(updatedUser.getEmail());
            userRepository.save(userExist);
            return userExist;
        } else {
            return null;
        }
    }

    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
