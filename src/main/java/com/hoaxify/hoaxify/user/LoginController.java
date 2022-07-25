package com.hoaxify.hoaxify.user;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.hoaxify.shared.CurrentUser;
import com.hoaxify.hoaxify.user.vm.UserVM;


@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	public UserVM handleLogin(@CurrentUser User loggedInUser) {
		return new UserVM(loggedInUser);
	}
	
	/* 
	
	// 1.way
	@PostMapping("/api/1.0/login")
	public Map<String, Object> handleLogin() {
		User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return Collections.singletonMap("id", loggedInUser.getId());
	}
	
	// 2.way
	@PostMapping("/api/1.0/login")
	public Map<String, Object> handleLogin(Authentication authentication) {
		User loggedInUser = (User) authentication.getPrincipal();
		return Collections.singletonMap("id", loggedInUser.getId());
	}
	
	*/
	
//	@ExceptionHandler({AccessDeniedException.class})
//	@ResponseStatus(HttpStatus.UNAUTHORIZED)
//	ApiError handle() {
//		return new ApiError(401, "Access error", "/api/1.0/login");
//	}

}
