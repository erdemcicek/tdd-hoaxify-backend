package com.hoaxify.hoaxify.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hoaxify.hoaxify.user.User;
import com.hoaxify.hoaxify.user.UserRepository;

@Service
public class AuthUserService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
	public AuthUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}
}
