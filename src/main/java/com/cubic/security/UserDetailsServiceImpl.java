package com.cubic.security;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cubic.dao.Signup;
import com.cubic.dao.SignupDao;

@Service   // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SignupDao signupDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// hard coding the users. All passwords must be encoded.
		/*
		 * final List<AppUser> users = Arrays.asList( new AppUser(1, "nagen",
		 * encoder.encode("12345"), "USER"), new AppUser(2, "manish",
		 * encoder.encode("12345"), "ADMIN") );
		 */
		
		Optional<Signup> optional=signupDao.findByUsername(username);
		if (optional.isPresent()) {
			Signup signup = optional.get();
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_" + signup.getRole());
			return new User(signup.getUsername(), encoder.encode(signup.getPassword()), grantedAuthorities);
		}
		// If user not found. Throw this exception.
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}
	
	// A (temporary) class represent the user saved in the database.
	private static class AppUser {
		private Integer id;
	    private String username, password;
	    private String role;
	    
		public AppUser(Integer id, String username, String password, String role) {
	    	this.id = id;
	    	this.username = username;
	    	this.password = password;
	    	this.role = role;
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
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
	    public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}
	}
}