package com.cubic.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class ValidateTokenFilter extends OncePerRequestFilter {

	private final JwtConfig jwtConfig;

	public ValidateTokenFilter(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		
		System.out.println("Path = "+request.getServletPath());
		

		// 1. get the authentication header. Tokens are supposed to be passed in the
		// authentication header
		String header = request.getHeader("Authorization");

		// 2. validate the header and check the prefix
		if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
			chain.doFilter(request, response); // If not valid, go to the next filter.
			return;
		}
		
		// 3. Get the token
		 String token = header.replace(jwtConfig.getPrefix(), "");
		 
		// 4. Validate the token
		Claims claims = Jwts.parser()
							.setSigningKey(jwtConfig.getSecret().getBytes())
							.parseClaimsJws(token)
							.getBody();
					
		String username = claims.getSubject();
		if(username!=null) {
			//List of ADMIN
			List<String> authorities = (List<String>) claims.get("authorities");
			List<SimpleGrantedAuthority> roles=new ArrayList<>(); 
			for(String role : authorities) {
				SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
				roles.add(authority);
			}
			
			// 5. Create auth object
			// UsernamePasswordAuthenticationToken: A built-in object, used by spring to represent the current authenticated / being authenticated user.
			// It needs a list of authorities, which has type of GrantedAuthority interface, where SimpleGrantedAuthority is an implementation of that interface
			 //UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
				//			 username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
			 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
					 username, null, roles);
			 // 6. Authenticate the user
			 // Now, user is authenticated
			 SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		
		// go to the next filter in the filter chain
		chain.doFilter(request, response);
	}
}
