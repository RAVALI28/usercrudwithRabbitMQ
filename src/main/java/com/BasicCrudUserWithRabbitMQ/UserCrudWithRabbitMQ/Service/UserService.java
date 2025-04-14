package com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Service;

import com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Model.User;
import com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;

    }

    public User getUserById(long id){
     return userRepository.findById(id).orElse(null);

    }

    public List<User> getAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User updateUser(Long id, User user){
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setEmail(user.getEmail());
            existingUser.setName(user.getName());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
