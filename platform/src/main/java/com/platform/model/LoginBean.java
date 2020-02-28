package com.platform.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {
	
@NotBlank(message = "username should not be empty")
@Size(min = 4,message = "Minimum 4 characters should be present")
@Size(max= 20,message = "Maximum 20 characters")
@Pattern(regexp = "[A-Za-z0-9@_]{4,20}",message = "Only use alphabets and letters,special characters '@' '_' are also allowed ")
private String username;

@Size(min=8,message = "Minimum 8 characters must be present")
@Size(max=20,message = "Maximum 20 characters could be present")
private String password;

private String loginAs;

@Email(message = "Enter valid email id")
private String emailId;
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLoginAs() {
	return loginAs;
}
public void setLoginAs(String loginAs) {
	this.loginAs = loginAs;
}


}
