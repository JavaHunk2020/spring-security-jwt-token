package com.cubic.dao;

import java.util.List;
import java.util.Optional;

public interface SignupDao {

	public void deleteById(int sid);
	public List<Signup> findAll();
	
	public void save(Signup signup);
	public Signup findById(int sid);
	void updateImage(int sid, String newimage);
	Signup findByUsernameAndPassword(String username, String password);
	void update(Signup signup);
	public Optional<Signup> findByUsername(String username);
	void updatePassword(String username, String newpassword);
}
