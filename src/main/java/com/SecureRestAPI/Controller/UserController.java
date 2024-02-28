package com.SecureRestAPI.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SecureRestAPI.model.User;
import com.SecureRestAPI.model.UserRecord;
import com.SecureRestAPI.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

	private UserService userService;

	@GetMapping(path = "getAll")
	public ResponseEntity<List<UserRecord>> getAllusers() {
		return new ResponseEntity<>(userService.getAllusers(), HttpStatus.FOUND);
	}

	@GetMapping(path = "/user/{email}")
	public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {
		return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
	}

	@PostMapping(path = "/addUser")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
		return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<>(userService.updataUser(user), HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{email}")
	public void deleteByEmail(@PathVariable("email") String email) {
		userService.delete(email);
	}
}
