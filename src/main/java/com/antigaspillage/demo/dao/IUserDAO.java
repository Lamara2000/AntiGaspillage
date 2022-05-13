package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.User;

import java.util.List;

public interface IUserDAO {

    public List<User> findAll();
    public void add(User user);
    public User findByEmail(String email);
    public void delete(User user);
}
