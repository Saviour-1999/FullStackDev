package com.example.peter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.security.auth.login.AccountException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.peter.dto.AuthenticateUserRequest;
import com.example.peter.dto.UserCreateRequest;
import com.example.peter.dto.UserResponse;
import com.example.peter.model.User;
import com.example.peter.services.UserService;

@Configuration
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	public ModelMapper modelMapper;
	UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	@GetMapping("user/alluser")
	@ResponseBody
	public List<UserResponse> getAllUser()
	{
		return userService.getAllUser().stream().map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
	}
	
	@PostMapping("user/create")
	public String createUser(@RequestBody UserCreateRequest request)
	{
		User user=modelMapper.map(request, User.class);
		return userService.createUser(user).getUser_id();
	}
	
	@PostMapping("user/Authenticate")
	public boolean authenticateUser(@RequestBody AuthenticateUserRequest authUser) throws AccountException
	{
		try
		{
			User user =userService.getUserById(authUser.getUsername()).orElseThrow(()-> new EntityNotFoundException("User not found"));
			if(user.getPassword().equals(authUser.getPassword()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
