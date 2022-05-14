package com.antigaspillage.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.antigaspillage.demo.data.Cart;

@Repository
@Transactional
public class CartDAO implements ICartDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Cart> findAll() {
		Query q = em.createQuery("select c from Cart c");
		return q.getResultList();
	}

	@Override
	public void add(Cart c) {
		em.persist(c);
	}

	@Override
	public Cart findByRef(Long id) {
		return em.getReference(Cart.class, id);
	}

	@Override
	public void delete(Cart c) {
		em.remove(c);
	}
	
	

}
