package com.cubic.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SignupDaoImpl implements SignupDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Signup findByUsernameAndPassword(String username, String password) {
		String sql = "select sid,username,password,email,mobile,image,"
				+ "gender,address from signup_tbl where username = ? and password = ?";
		List<Signup> signups = jdbcTemplate.query(sql,new Object[] {username , password}, 
				new BeanPropertyRowMapper<>(Signup.class));
		//This ternary operator
		return signups.size()>0 ? signups.get(0) : null;
	}
	
	
	@Override
	public void deleteById(int sid) {
		String sql = "delete from signup_tbl where  sid = ? ";
		jdbcTemplate.update(sql,new Object[] {sid});
	}

	@Override
	public List<Signup> findAll() {
		String sql = "select sid,username,password,email,mobile,image,gender,address from signup_tbl";
		List<Signup> signups = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Signup.class));
		return signups;
	}
	

	@Override
	public boolean findByUsername(String username) {
		String sql = "select username from signup_tbl where username  = ? ";
		List<String> signups = jdbcTemplate.query(sql,new Object[] {username} ,new BeanPropertyRowMapper<>(String.class));
		return signups.size() > 0;
	}
	
	@Override
	public void updatePassword(String username, String newpassword) {
		String sql = "update  signup_tbl set password =? where username = ?";
		jdbcTemplate.update(sql, new Object[] { newpassword ,username});
	}
	
	
	
	@Override
	public void updateImage(int sid, String newimage) {
		String sql = "update  signup_tbl set image =? where sid = ?";
		jdbcTemplate.update(sql, new Object[] { newimage ,sid});
	}
	
	@Override
	public Signup findById(int sid) {
		String sql = "select sid,username,password,email,mobile,image,"
				+ "gender,address from signup_tbl where sid = ?";
		List<Signup> signups = jdbcTemplate.query(sql,new Object[] {sid}, 
				new BeanPropertyRowMapper<>(Signup.class));
		
		return signups.get(0);
	}
	
	
	@Override
	public void update(Signup signup) {
		String sql = "update signup_tbl set username =? ,password = ? ,email = ? ,mobile =? , image= ? ,gender=?, address=? where sid= ?";
		jdbcTemplate.update(sql, new Object[] { signup.getUsername(), signup.getPassword(), signup.getEmail(),
				signup.getMobile(), signup.getImage(), signup.getGender(), signup.getAddress(), signup.getSid()});
	}
	
	@Override
	public void save(Signup signup) {
		String sql = "insert into signup_tbl(username,password,email,mobile,image,gender,address) "
				+ "values(?,?,?,?,?,?,?)";

		jdbcTemplate.update(sql, new Object[] { signup.getUsername(), signup.getPassword(), signup.getEmail(),
				signup.getMobile(), signup.getImage(), signup.getGender(), signup.getAddress() });
	
	}
}
