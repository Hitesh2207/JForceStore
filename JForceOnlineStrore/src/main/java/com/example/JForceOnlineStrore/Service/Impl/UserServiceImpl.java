package com.example.JForceOnlineStrore.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JForceOnlineStrore.Model.User;
import com.example.JForceOnlineStrore.Repository.UserRepository;
import com.example.JForceOnlineStrore.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public String userRegister(User user) {

		try {
			if (user.getEmail() == null || user.getEmail().isEmpty()) {
				return "User Email is Required";
			} else if (user.getUsername() == null || user.getUsername().isEmpty()) {
				return "User Name is Required";
			} else if (user.getUsername() == null || user.getUsername().isEmpty()) {
				return "Password is Required";
			}

			userRepository.save(user);
			System.out.println("Regiseterd");

			return "User Registered";

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	@Override
	public User login(User user) {

		try {
			String username = user.getUsername();
			String password = user.getPassword();

			User byUsernameAndEmail = userRepository.findByUsernameAndPassword(username, password);
			if (byUsernameAndEmail == null) {
				throw new RuntimeException("Username And Password is Incorrect");
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

	}

}
