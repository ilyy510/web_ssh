package com.web.dao;

import java.util.List;

import com.web.model.User;

public interface UserDao {
public void save(User user) ;
public boolean  checkUserExistsWithName(String username);
public List<User> getUsers();
}
