package com.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.web.dao.UserDao;
import com.web.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
	return sessionFactory;
}
	
@Resource
public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
		/*
		 * SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		 * Session session=sessionFactory.getCurrentSession();
		 * session.beginTransaction(); session.save(user);
		 * session.getTransaction().commit();
		 */
	}

	@Override
	@Transactional
	public boolean checkUserExistsWithName(String username) {
		// TODO Auto-generated method stub
		/*
		 * SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		 * Session session=sessionFactory.getCurrentSession();
		 * session.beginTransaction(); Long count =(Long) session.createQuery(
		 * "select count(*) from User user where user.username=:username")
		 * .setString("username", username) .uniqueResult();
		 * 
		 * session.getTransaction().commit(); if(count>0) { return true; }
		 * return false;
		 */
		// List<?> users=
		// hibernateTemplate.find("from User u where u.username ='"+username+"'");
		Long count = (Long) sessionFactory.getCurrentSession().createQuery("select count(*) from User user where user.username=:username")
				.setString("username", username).uniqueResult();
		System.out.println(username+"   "+count);		
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
	}
}
