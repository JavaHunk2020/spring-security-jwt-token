package com.cubic;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

	@Value("${mysql.url}")
	private String url;
	@Value("${mysql.driver.name}")
	private String driver;
	@Value("${mysql.username}")
	private String username;
	@Value("${mysql.password}")
	private String password;
	/*
	 * @Bean public WebClient webClient() { return WebClient.builder() .baseUrl(
	 * "https://media.istockphoto.com/photos/beautiful-smiling-female-college-student-picture-id1340766096?b=1&k=20&m=1340766096&s=170667a&w=0&h=P-ay9mgiAn5O_eg3JOfaKIpDTu-_p70NyIsEhVcEFco=")
	 * .build(); }
	 */

	// This annotation register this object as bean inside spring container
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);// change url
		dataSource.setUsername(username);// change userid
		dataSource.setPassword(password);// change pwd
		return dataSource;
	}

	// <bean id ="jdbcTemplate" class
	// ="org.springframework.jdbc.core.JdbcTemplate"/>
	@Bean
	public JdbcTemplate createJdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource());
		return jdbcTemplate;
	}

}
