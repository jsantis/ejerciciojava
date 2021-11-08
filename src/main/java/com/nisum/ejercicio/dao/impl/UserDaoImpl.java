package com.nisum.ejercicio.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.nisum.ejercicio.dao.UserDao;
import com.nisum.ejercicio.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@PersistenceContext
    private EntityManager entityManager;
	
	public List<User> getUsers() {
		return this.getUsersbyEmail(null);		
	}
	
	public List<User> getUsersbyEmail(String email) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query= cb.createQuery(User.class);
		Root<User> variableRoot = query.from(User.class);
	    query.select(variableRoot);
	    
	    if(email != null) {
		    List<Predicate> predicates = new ArrayList<Predicate>();
		    predicates.add(cb.like(variableRoot.get("email"),""+email));
		    query.select(variableRoot).where(predicates.toArray(new Predicate[predicates.size()]));
	    }
	    
		return entityManager.createQuery(query).getResultList(); 
	}
	
	public User saveUser(User user) {
		
		Session session = entityManager.unwrap(Session.class);	 
	    
		//Valores default
		user.setCreated(new Date());
		user.setModified(new Date());
		user.setLastLogin(new Date());
		UUID uuid = UUID.randomUUID();
		user.setToken(uuid);
	    session.save(user);
		
		return user;
	}
}
