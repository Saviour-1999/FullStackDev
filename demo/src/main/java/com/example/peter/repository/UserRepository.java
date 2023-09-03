package com.example.peter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.peter.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String>{

}
