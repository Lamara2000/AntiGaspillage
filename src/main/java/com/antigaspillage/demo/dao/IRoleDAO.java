package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Role;

import java.util.List;

public interface IRoleDAO {
    public List<Role> findAll();
    public void add(Role role);
    public Role findByName(String name);
    public void delete(Role role);
    
}
