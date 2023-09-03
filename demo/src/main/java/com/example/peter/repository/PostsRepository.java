package com.example.peter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.peter.model.Posts;

@Repository
@Transactional
public interface PostsRepository extends JpaRepository<Posts, String>{

}
