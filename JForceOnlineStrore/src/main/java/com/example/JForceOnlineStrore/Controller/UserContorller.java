package com.example.JForceOnlineStrore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JForceOnlineStrore.Model.User;
import com.example.JForceOnlineStrore.Service.UserService;

@RestController
@RequestMapping("/apiUser")
@CrossOrigin("http://localhost:5173/")
public class UserContorller {

	@Autowired
	UserService service;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody User user) {

		try {
			User userRegister = service.login(user);
			return new ResponseEntity<>(userRegister, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/register")
	public String Register(@RequestBody User user) {

		try {
			String response = service.userRegister(user);
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
