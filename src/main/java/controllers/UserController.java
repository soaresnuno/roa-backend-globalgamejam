package controllers;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import repositories.UserRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static String UPLOAD_FOLDER = "src/main/resources/img/";

    @PostMapping (value = "/register", produces = "application/json")
    public ResponseEntity<User> register(@RequestBody User user){
        User newUser = userRepository.save(user);
        return new ResponseEntity("User register sucessfully!", HttpStatus.OK);
    }

    @PostMapping (value = "/users/upload")
    public ResponseEntity uploadImage(@RequestParam("file")MultipartFile file){
     //   String filename = file.getOriginalFilename();
        byte[] filename = new byte[0];
        try {
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity(filename, HttpStatus.OK);
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
