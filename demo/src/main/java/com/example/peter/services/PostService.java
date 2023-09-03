package com.example.peter.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.peter.dto.PostResponse;
import com.example.peter.model.Posts;
import com.example.peter.repository.PostsRepository;

@Service
public class PostService {
	private final PostsRepository postRepo;
	
	@Autowired
	public ModelMapper modelMapper; 
	
	public PostService(PostsRepository postRepo)
	{
		this.postRepo=postRepo;
	}
	
	public Posts createPost(Posts post)
	{
		return postRepo.save(post);
	}
	
	public Page<PostResponse> getPosts(Pageable pageable)
	{
//		List<Posts> posts= postRepo.findAll();
//		return posts.stream().map(this:: converToPostResponse).collect(Collectors.toList());
		Page<Posts> postsPage= postRepo.findAll(pageable);
		return postsPage.map((this::converToPostResponse));
	}
	
	public Optional<Posts> getPostById(String id)
	{
		return postRepo.findById(id);
	}
	
	private PostResponse converToPostResponse(Posts post)
	{
		PostResponse postResponse = modelMapper.map(post, PostResponse.class);
		postResponse.setUser_id(post.getUser().getUser_id());
		return postResponse;
	}

}
