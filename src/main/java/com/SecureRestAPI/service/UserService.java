package com.SecureRestAPI.service;

import java.util.List;

import com.SecureRestAPI.model.User;
import com.SecureRestAPI.model.UserRecord;

public interface UserService {

	User addUser(User user);

	List<UserRecord> getAllusers();

	User getUser(String email);

	User updataUser(User User);

	void delete(String email);

}
