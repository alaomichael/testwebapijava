package com.sigmaoct.testwebapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final UserRepository userRepository;
    @Autowired
    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String greet() {
        return "Hello";
    }

    @PostMapping
    public String greetUser(@RequestBody User user) {
        return "Hello " + user.getName();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Could not find"));
    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
