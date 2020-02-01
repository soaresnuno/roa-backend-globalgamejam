package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping (value = "/register", produces = "application/json")
    public ResponseEntity<User> register(@RequestBody User user){
        User newUser = userRepository.save(user);
        return new ResponseEntity("User register sucessfully!", HttpStatus.OK);
    }

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<List<User>> getUsers(){
        List<User> showAllUsers = (List<User>) userRepository.findAll();
        return new ResponseEntity<List<User>>(showAllUsers, HttpStatus.OK);
    }

    @GetMapping(value = "users/{id}", produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable (value= "id") Long id){
        Optional<User> user = userRepository.findById(id);
        return new ResponseEntity<User>(user.get(), HttpStatus.OK);
    }

    @PutMapping (value = "/users/update", produces = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User userUpdated = userRepository.save(user);
        return new ResponseEntity("User updated sucessfuly", HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}/delete", produces = "application/json")
    public ResponseEntity<User> delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
        return new ResponseEntity("User deleted", HttpStatus.OK);
    }

}
