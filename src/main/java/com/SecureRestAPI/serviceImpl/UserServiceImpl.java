package com.SecureRestAPI.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SecureRestAPI.exception.UserAlreadyExistException;
import com.SecureRestAPI.exception.UserNotFoundException;
import com.SecureRestAPI.model.User;
import com.SecureRestAPI.model.UserRecord;
import com.SecureRestAPI.repository.UserRepository;
import com.SecureRestAPI.service.UserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private PasswordEncoder passwordEncoder;

	@Override
	public User addUser(User user) {
		Optional<User> useremail = userRepository.findByEmail(user.getEmail());
		if (useremail.isPresent()) {
			throw new UserAlreadyExistException("A user with " + user.getEmail() + " already exist");
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public List<UserRecord> getAllusers() {

		return userRepository.findAll().stream()
				.map(user -> new UserRecord(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail()))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public User getUser(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("User not found!"));
	}

	@Override
	public User updataUser(User user) {
		user.setRoles(user.getRoles());
		return userRepository.save(user);
	}

	@Override
	public void delete(String email) {
		userRepository.deleteByEmail(email);
	}

}
