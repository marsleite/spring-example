package com.example.example.controller;

import com.example.example.dto.UserDTO;
import com.example.example.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
  private List<User> users = new ArrayList<>();

  @GetMapping("/lista")
  public List<User> getUsers() {
    return users;
  }

  @PostMapping("/")
  public List<User> createUser(@RequestBody User user){
    users.add(user);
    return users;
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable("id") Long id) {
    Optional<User> data = users.stream().filter(user -> user.getId() == id).findFirst();

    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }
}
