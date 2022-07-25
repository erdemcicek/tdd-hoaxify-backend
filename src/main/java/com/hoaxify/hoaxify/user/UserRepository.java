package com.hoaxify.hoaxify.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
	
	Page<User> findByUsernameNot(String username, Pageable page);

	
}


//List<User> findByUsernameContaining(String username);

	//User findByUsernameAndDisplayName(String username, String displayName);


//@Query(value ="SELECT * FROM USERS", nativeQuery = true)  // native
//@Query("Select u from User u")								// JPQL
//Page<UserProjection> getAllUsersProjection(Pageable pageable);