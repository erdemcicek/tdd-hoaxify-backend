package com.hoaxify.hoaxify.error;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@RestController
public class ErrorHandler implements ErrorController {
	
	private final ErrorAttributes errorAttributes;
	
	
	public ErrorHandler(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}
	
	
	@RequestMapping("/error")
	ApiError handleError(WebRequest webRequest) {
		Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(Include.MESSAGE));
		
		String message = (String) attributes.get("message");
		String url = (String) attributes.get("path");
		int status = (int) attributes.get("status");
		return new ApiError(status, message, url);
	}

}
