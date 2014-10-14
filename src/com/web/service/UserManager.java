package com.web.service;

import java.util.List;

import com.web.model.User;

public interface UserManager {

	public abstract boolean exists(User user) throws Exception;

	public abstract void add(User user) throws Exception;

	public abstract List<User> getUsers();

}