package com.example.peter.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.peter.model.Comments;
import com.example.peter.model.Posts;

@Repository
@Transactional
public interface CommentsRepository extends JpaRepository<Comments, String>{
	List<Comments> findAll();
	Page<Comments>findByPost(Posts post, Pageable pageable);
}
