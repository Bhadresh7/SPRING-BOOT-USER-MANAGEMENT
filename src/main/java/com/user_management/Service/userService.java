package com.user_management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.user_management.Entity.userDetails;
import com.user_management.Repository.userRepository;

@Service
public class userService {

	@Autowired

	private userRepository userRepo;

	//Fetching all the users
	public List<userDetails> getall() {
		return userRepo.findAll();
	}


	//Creating new user 
	public  userDetails newUser(userDetails user) {
		return userRepo.save(user);
	}


	//updating the user
	public userDetails updateUser(Long id,userDetails user) {

		userDetails use=userRepo.getReferenceById(id);//getId id deprecated instead use this
		use.setFirstname(user.getFirstname());
		use.setLastname(user.getLastname());
		use.setPassword(user.getPassword());
		use.setEmail(user.getEmail());
		use.setConfirmpassword(user.getConfirmpassword());
		userRepo.save(use);
		return use;

	}

	//deleting the user

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}


}
