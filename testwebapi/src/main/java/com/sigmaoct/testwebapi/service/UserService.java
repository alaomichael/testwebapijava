package com.sigmaoct.testwebapi.service;

import com.sigmaoct.testwebapi.persistence.User;

import java.util.List;

public interface UserService {
    public User create (User user);
    public User update (User user);
    public User fetch (String id);
    public List<User> list();
    public  User delete (String id);
}
