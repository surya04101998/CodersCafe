package com.platform.model;

import org.springframework.stereotype.Component;

@Component
public class LoginBean {
private String username;
private String password;
private String loginAs;
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
