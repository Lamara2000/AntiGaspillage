package com.antigaspillage.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.antigaspillage.demo.data.Trader;

import java.util.List;

@Repository
@Transactional
public class TraderDAO implements ITraderDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Trader> findAll() {
		return null;
	}

	@Override
	public void add(Trader trader) {

	}

	@Override
	public Trader findByName(String name) {
		return null;
	}

	@Override
	public void delete(Trader role) {

	}

	@Override
	public Trader findByRef(Long id) {
		return em.getReference(Trader.class, id);
	}

}
