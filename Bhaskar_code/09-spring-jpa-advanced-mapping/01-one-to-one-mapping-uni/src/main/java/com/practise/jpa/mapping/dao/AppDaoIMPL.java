package com.practise.jpa.mapping.dao;

import org.springframework.stereotype.Repository;

import com.practise.jpa.mapping.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoIMPL implements AppDao {

	private EntityManager manager;

	public AppDaoIMPL(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		manager.persist(instructor);
	}

}
