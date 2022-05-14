package com.antigaspillage.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.antigaspillage.demo.data.Trader;

@Repository
@Transactional
public class TraderDAO implements ITraderDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public Trader findByRef(Long id) {
		return em.getReference(Trader.class, id);
	}

}
