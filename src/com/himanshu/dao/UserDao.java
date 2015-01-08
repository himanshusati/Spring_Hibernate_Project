package com.himanshu.dao;

import java.util.List;

import com.himanshu.domain.User;
import com.himanshu.domain.UserAddress;

public interface UserDao {
public void saveUser ( User user );
public List<User> getUser();
public User checklogin(String username);
public void saveAddress(UserAddress address);
}
