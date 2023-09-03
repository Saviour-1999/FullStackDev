package com.example.peter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.peter.dto.PostCreateRequest;
import com.example.peter.dto.PostResponse;
import com.example.peter.model.Posts;
import com.example.peter.model.User;
import com.example.peter.services.PostService;
import com.example.peter.services.UserService;

@Configuration
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	@Autowired
	public ModelMapper modelMapper;
	
	PostService postService;
	
	@Autowired
	UserService userService;
	
	public PostController(PostService postService)
	{
		this.postService=postService;
	}
	
	@GetMapping("post/viewPost")
	@ResponseBody
	public Page<PostResponse> getPosts(Pageable pageable)
	{
		return postService.getPosts(pageable);
	}
	
	@GetMapping("post/{id}")
	@ResponseBody
	public PostResponse getPostByPostId(@PathVariable("id") String post_id)
	{
		Posts post =postService.getPostById(post_id).orElseThrow(()-> new EntityNotFoundException("User not found"));
		return modelMapper.map(post, PostResponse.class);
	}
	
	@PostMapping("post/create")
	public String createPost(@RequestBody PostCreateRequest request)
	{
		Posts post=modelMapper.map(request, Posts.class);
		User user =userService.getUserById(request.getUser_id()).orElseThrow(()-> new EntityNotFoundException("User not found"));
		post.setUser(user);
		return postService.createPost(post).getPost_id();
	}
}
