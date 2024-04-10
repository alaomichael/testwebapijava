package com.sigmaoct.testwebapi.service;

import com.sigmaoct.testwebapi.exception.UserNotFoundException;
import com.sigmaoct.testwebapi.persistence.User;
import com.sigmaoct.testwebapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        User newUser = userRepository.save(user);
//        newUser.setName("cool");
        return newUser;
    }

    @Override
    public User update(User user) {
        User newUser = userRepository.save(user);
        return newUser;
    }

    @Override
    public User fetch(String id) {
        //Optional<User> userOpt = userRepository.findById(id);
        //User newUser = userOpt.orElseThrow(()->{return new UserNotFoundException(id);});
        User newUser = userRepository.findById(id).orElseThrow(()->{return new UserNotFoundException(id);});
        return newUser;
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User delete(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> {return new UserNotFoundException(id);});
        userRepository.delete(user);
        return user;
    }
}
