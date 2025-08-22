package com.cbfacademy.api_assessment.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/stock-portfolio/users")
public class UserController {
      private UserService userService;

    public UserController(UserService userService){
         this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
            return userService.getAllUsers();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUserById(@PathVariable UUID id) {
        try{
           return userService.getUser(id);
        }
       catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", exception);
        }
          
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
          User createdUser = userService.createUser(user);
          return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping(value = "/{id}", produces = "application/json")
    public User updateUser(@RequestBody User user, @PathVariable UUID id) {
        try{
            return userService.updateUser(id, user);
        }
        catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", exception);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable UUID id){
        try{
           userService.deleteUser(id);
        }
        catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", exception);
        }
    }
}
