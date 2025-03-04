package com.sawlov2code.rmbackend.user.service;


import com.sawlov2code.rmbackend.user.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sawlov2code.rmbackend.user.model.Users;

@Service
public class UserService {
	
@Autowired
	private UserRepo repo;
private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	@Transactional
	public Users saveUser(Users user) {
		if (user.getPassword() == null) {
			throw new IllegalArgumentException("Password cannot be null");
		}
		user.setPassword(encoder.encode(user.getPassword()));
	return repo.save(user) ;
		
	}
}
