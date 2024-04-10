package com.sigmaoct.testwebapi.controller;

import com.sigmaoct.testwebapi.repository.UserRepository;
import com.sigmaoct.testwebapi.persistence.User;
import com.sigmaoct.testwebapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final UserService userService;
    @Autowired
    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String greet() {
        return "Hello";
    }

//    @PostMapping
//    public String greetUser(@RequestBody User user) {
//        return "Hello " + user.getName();
//    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.fetch(id);
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.list();
    }
}
