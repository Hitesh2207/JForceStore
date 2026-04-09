package com.example.JForceOnlineStrore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JForceOnlineStrore.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsernameAndPassword(String username, String password);

	public User findByUsername(String userName);

}
