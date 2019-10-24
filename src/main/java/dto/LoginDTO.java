package dto;

public class LoginDTO {
	
private String UserId;	
private String firstName;
private String lastName;
//private String password;
private String emailId;
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
//public String getPassword() {
//	return password;
//}
//public void setPassword(String password) {
//	this.password = password;
//}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}



}
