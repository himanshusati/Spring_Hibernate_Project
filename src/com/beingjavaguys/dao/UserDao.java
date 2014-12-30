package com.beingjavaguys.dao;

import java.util.List;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.domain.UserAddress;

public interface UserDao {
public void saveUser ( User user );
public List<User> getUser();
public User checklogin(String username);
public void saveAddress(UserAddress address);
}
