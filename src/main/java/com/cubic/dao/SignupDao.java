package com.cubic.dao;

import java.util.List;

public interface SignupDao {

	public void deleteById(int sid);
	public List<Signup> findAll();
	
	public void save(Signup signup);
	public Signup findById(int sid);
	void updateImage(int sid, String newimage);
	Signup findByUsernameAndPassword(String username, String password);
	void update(Signup signup);
	boolean findByUsername(String username);
	void updatePassword(String username, String newpassword);
}
