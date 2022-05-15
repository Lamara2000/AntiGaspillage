package com.antigaspillage.demo.dao;

import com.antigaspillage.demo.data.Cart;
import com.antigaspillage.demo.data.Role;
import com.antigaspillage.demo.data.Trader;

import java.util.List;

public interface ITraderDAO {
    public List<Trader> findAll();
    public void add(Trader trader);
    public Trader findByName(String name);
    public void delete(Trader role);
    public Trader findByRef(Long id);

}
