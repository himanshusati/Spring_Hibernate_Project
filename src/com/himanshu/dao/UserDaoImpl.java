package com.himanshu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himanshu.domain.User;
import com.himanshu.domain.UserAddress;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUser(User user) {
		sessionfactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> getUser() {
		@SuppressWarnings("unchecked")
		List<User> userlist = sessionfactory.getCurrentSession()
				.createCriteria(User.class).list();
		return userlist;
	}

	@Override
	public User checklogin(String username) {
		// TODO Auto-generated method stub
		Query createQuery = sessionfactory.getCurrentSession().createQuery("FROM User WHERE userName = :id");
		createQuery.setParameter("id", username);
		Object uniqueResult = createQuery.uniqueResult();
		return (User) uniqueResult;
	}

	@Override
	public void saveAddress(UserAddress address) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(address);
		
	}

}
