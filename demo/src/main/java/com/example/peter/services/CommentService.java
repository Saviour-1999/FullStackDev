package com.example.peter.services;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.peter.dto.CommentResponse;
import com.example.peter.model.Comments;
import com.example.peter.model.Posts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.example.peter.repository.CommentsRepository;

@Service
public class CommentService {
	private final CommentsRepository commentRepo;
	@Autowired
	public ModelMapper modelMapper;
	
	public CommentService(CommentsRepository commentRepo)
	{
		this.commentRepo=commentRepo;
	}
	
	public Comments createComment(Comments comment)
	{
		return commentRepo.save(comment);
	}
	
	public List<Comments> getComments()
	{
		return commentRepo.findAll();
	}
	
	public Page<Comments> getCommentByPost(Posts post, Pageable pageable)
	{
		return commentRepo.findByPost(post, pageable);
		//return comments.map(response-> modelMapper.map(response,CommentResponse.class));
		
		//comments.map
		//return commentRepo.findByPost(post,pa);
	}
}
