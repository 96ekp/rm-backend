package com.sawlov2code.rmbackend.user.dao;


import com.sawlov2code.rmbackend.user.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
	Users findByUsername(String username);
}
