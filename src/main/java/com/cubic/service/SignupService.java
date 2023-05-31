package com.cubic.service;

import java.util.List;

import com.cubic.dto.SignupDTO;

public interface SignupService {

	public void deleteById(int sid);
	public List<SignupDTO> findAll();
	
	public void save(SignupDTO signup);
	public SignupDTO findById(int sid);
	void updateImage(int sid, String newimage);
	SignupDTO findByUsernameAndPassword(String username, String password);
	void update(SignupDTO signupDTO);
	boolean findByUsername(String username);
	void updatePassword(String username, String newpassword);
}
