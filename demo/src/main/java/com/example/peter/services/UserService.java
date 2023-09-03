package com.example.peter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.peter.model.User;
import com.example.peter.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
	public UserService(UserRepository userRepo)
	{
		this.userRepo=userRepo;
	}
	public List<User> getAllUser()
	{
		return userRepo.findAll();
	}
	public User createUser(User user) {
		return userRepo.save(user);
		
	}
	public Optional<User> getUserById(String id)
	{
		return userRepo.findById(id);
	}
	
}
