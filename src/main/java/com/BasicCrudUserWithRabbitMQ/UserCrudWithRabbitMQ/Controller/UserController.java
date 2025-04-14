package com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Controller;

import com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Model.User;
import com.BasicCrudUserWithRabbitMQ.UserCrudWithRabbitMQ.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User -- /api/users/createUser
    @PostMapping("/createUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
       User savedUser = userService.createUser(user);
       return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Get User  By Id -- /api/users/{id}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserId(@PathVariable Long id){
        User userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    //Get All Users -- /api/users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    //Update User -- /api/users/{id}
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user){
       User updatedUser  = userService.updateUser(id, user);
       return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    //Delete User - /api/users/{id}
        @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted Successfully");
    }

}
