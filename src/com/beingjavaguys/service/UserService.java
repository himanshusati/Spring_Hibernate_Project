package com.beingjavaguys.service;

import java.util.List;

import com.beingjavaguys.domain.User;
import com.beingjavaguys.domain.UserAddress;

public interface UserService {
	public void addUser(User user);

	public List<User> getUser();
	public User checklogin(String username);
	public void addAddress(UserAddress address);
}
