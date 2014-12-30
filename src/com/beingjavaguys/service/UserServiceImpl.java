package com.beingjavaguys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beingjavaguys.dao.UserDao;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.domain.UserAddress;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}

	@Override
	public User checklogin(String username) {
		// TODO Auto-generated method stub
		return userDao.checklogin(username);
	}

	@Override
	public void addAddress(UserAddress address) {
		// TODO Auto-generated method stub
		userDao.saveAddress(address);
	}

}
