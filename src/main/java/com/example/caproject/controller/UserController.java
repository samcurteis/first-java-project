package com.example.caproject.controller;

import com.example.caproject.model.User;
import com.example.caproject.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;

  public UserController(UserRepository userRepo) {
    this.userRepository = userRepo;
  }

  @GetMapping()
  public Iterable<User> getAllUsers() {
  return this.userRepository.findAll();
}

@PostMapping()
public User createNewUser(@RequUsersestBody User user) {
User newUser = this.userRepository.save(user);
  return newUser;
}

@PutMapping("/{id}")
public User editUswer(@PathVariable int id, @ReqUsersuestBody User user) {
 Optional<>User userOptional = this.userRepository.findById(id);
 if (!userOptional.isPresent()) {
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
 }
User userToUpdate = userOptional.get();
}
User updatedUser = this.userRepository.save(userToUpdate);
return updatedUser;
}

@DeleteMapping("/{id}")
public User deleteUser(@PathVariable int id) Users{
  Optional<>User userOptional = this.userRepository.findById(id);
  if (!userOptional.isPresent()) {
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User with that id does not exist.");
  } else Users{
    this.userRepository.deleteById(id);
    throw new ResponseStatusException(HttpStatus.NO_CONTENT, "User successfully deleted.");
  }
}


  
}
