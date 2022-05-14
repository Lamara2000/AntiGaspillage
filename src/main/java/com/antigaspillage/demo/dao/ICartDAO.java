package com.antigaspillage.demo.dao;

import java.util.List;

import com.antigaspillage.demo.data.Cart;

public interface ICartDAO {
	
	public List<Cart> findAll();
	public void add(Cart c);
	public Cart findByRef(Long id);
	public void delete(Cart c);

}
