package com.user_management.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user_management.Entity.userDetails;
import com.user_management.Service.userService;


@RestController
@CrossOrigin(origins = "http://locahost:3000")
@RequestMapping("/api/user")
public class userController {

	@Autowired
	private userService userservice;



	//API for the fetching all the users

	@GetMapping("/get")
	public ResponseEntity<List<userDetails>>getall(){
		List<userDetails> user = userservice.getall(); //done
		return ResponseEntity.ok(user);
	}


	//API for adding new user

	@PostMapping("/add")
	public  userDetails addNewUser(@RequestBody userDetails user) {
		user.setFirstname(user.getFirstname());
		user.setLastname(user.getLastname());
		user.setEmail(user.getEmail());				//done
		user.setPassword(user.getPassword());
		user.setConfirmpassword(user.getConfirmpassword());

		return userservice.newUser(user);
	}



	@PostMapping("/new")
	public ResponseEntity<userDetails> addnewUser(@RequestBody userDetails user) {
		userDetails user1= userservice.newUser(user);
		return new ResponseEntity<>(user1,HttpStatus.CREATED);
	}




	//API for updating the user
	@PutMapping("/update/{id}")
	public userDetails updateUserDetails (@PathVariable Long id,@RequestBody userDetails user) {
		return userservice.updateUser(id, user);		
	}
	//API for deleting the user

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser (@PathVariable Long id) {
		userservice.deleteUser(id);	
		return ResponseEntity.ok("Successfully deleted");
	}
}
