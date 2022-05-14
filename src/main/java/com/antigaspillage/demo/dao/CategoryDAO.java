package com.antigaspillage.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.antigaspillage.demo.data.Category;

@Repository
@Transactional
public class CategoryDAO implements ICategoryDAO {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Category> findAll() {
		Query q = em.createQuery("select c from Category c");
		return q.getResultList();
	}

}
