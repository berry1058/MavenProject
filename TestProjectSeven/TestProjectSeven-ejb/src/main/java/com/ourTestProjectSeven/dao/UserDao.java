package com.ourTestProjectSeven.dao;

import javax.ejb.Local;

import com.ourTestProjectSeven.model.User;

@Local
public interface UserDao extends Dao<User> {

	String NAME = "userDao";
	String JNDI_NAME = "java:app/TestProjectSeven-ejb/UserDaoBean";

	User findByUsername(String username);

}
