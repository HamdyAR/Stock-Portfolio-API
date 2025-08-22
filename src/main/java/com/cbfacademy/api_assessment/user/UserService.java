package com.cbfacademy.api_assessment.user;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUser(UUID id) throws NoSuchElementException{
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id" + id + "not found"));
    }


    public User createUser(User user) throws IllegalArgumentException, OptimisticLockingFailureException{
    if(user.getUserId() != null){
        throw new IllegalArgumentException("User already exists");
    }
    try{
        return userRepository.save(user);
    }
    catch(OptimisticLockingFailureException e){
        throw e;
    }
}

public User updateUser(UUID id, User updatedUser) throws NoSuchElementException{
    User existingUser = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));

    existingUser.setFirstName(updatedUser.getFirstName());
    existingUser.setLastName(updatedUser.getLastName());

    return userRepository.save(existingUser);
}

public void deleteUser(UUID id) throws NoSuchElementException{
    userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User with id " + id + " not found"));
    userRepository.deleteById(id);
}
}
