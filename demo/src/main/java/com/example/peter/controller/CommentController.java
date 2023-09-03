package com.example.peter.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.aspectj.weaver.World.TypeMap;
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
import org.w3c.dom.Comment;

import com.example.peter.DemoApplication;
import com.example.peter.dto.CommentRequest;
import com.example.peter.dto.CommentResponse;
import com.example.peter.model.Comments;
import com.example.peter.model.Posts;
import com.example.peter.model.User;
import com.example.peter.services.CommentService;
import com.example.peter.services.PostService;
import com.example.peter.services.UserService;

import ch.qos.logback.classic.Logger;

@Configuration
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	@Autowired
	public ModelMapper modelMapper;
	
	CommentService commentService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;
	
	
	
	public CommentController(CommentService commentService)
	{
		this.commentService=commentService;
	}
	
	@GetMapping("comments/{post_id}")
	@ResponseBody
	public Page<CommentResponse> getCommentsByPostId(@PathVariable("post_id") String post_id, Pageable pageable)
	{
		Posts post =postService.getPostById(post_id).orElseThrow(()-> new EntityNotFoundException("User not found"));
		var comments= commentService.getCommentByPost(post, pageable);
		var commentsPage = comments.map(response-> modelMapper.map(response,CommentResponse.class));
		//var commentResponse=comments.stream().map(comment -> modelMapper.map(comment, CommentResponse.class)).collect(Collectors.toList());
		for(int i=0; i<commentsPage.getContent().size();i++)
		{
			commentsPage.getContent().get(i).setPost_id(comments.getContent().get(i).getPost().getPost_id());
			commentsPage.getContent().get(i).setUser_id(comments.getContent().get(i).getUser().getUser_id());
		}
		return commentsPage;
	}
	
	@PostMapping("comments/create")
	public String createComment(@RequestBody CommentRequest request)
	{
		Comments comment=modelMapper.map(request, Comments.class);
		User user =  userService.getUserById(request.getUser_id()).orElseThrow(()->new EntityNotFoundException("User not found"));
		comment.setUser(user);
		Posts post = postService.getPostById(request.getPost_id()).orElseThrow(()->new EntityNotFoundException("Post not found"));
		comment.setPost(post);
		return commentService.createComment(comment).getComment_id();
	}
}
