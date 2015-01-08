package com.himanshu.service;

import java.util.List;

import com.himanshu.domain.User;
import com.himanshu.domain.UserAddress;

public interface UserService {
	public void addUser(User user);

	public List<User> getUser();
	public User checklogin(String username);
	public void addAddress(UserAddress address);
}
