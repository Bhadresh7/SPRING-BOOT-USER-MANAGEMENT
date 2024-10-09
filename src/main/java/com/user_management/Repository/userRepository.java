package com.user_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user_management.Entity.userDetails;

@Repository
public interface userRepository extends JpaRepository<userDetails,Long> {

	userDetails findByEmail(String email);
	
	 void deleteById(Integer id);

	
}
