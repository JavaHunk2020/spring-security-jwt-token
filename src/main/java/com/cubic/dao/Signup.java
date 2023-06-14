package com.cubic.dao;

/**
 * 
 * @author javahunk
 * 
 * This is only used for database
 *
 */
public class Signup {
    private int sid;
	public String username;
	private String password;
	private String email;
	private String mobile;
	private String gender;
	private String address;
	private String role;
	private String image;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public Signup() {
	}

	public Signup(String username, String password, String email, String mobile, String image,String gender, String address
			) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
		this.image = image;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Signup [sid=" + sid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", mobile=" + mobile + ", gender=" + gender + ", address=" + address + ", image=" + image + "]";
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
