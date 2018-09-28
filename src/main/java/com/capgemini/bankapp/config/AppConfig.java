package com.capgemini.bankapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.capgemini.bankapp"})
@PropertySource(value="classpath:db.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.dburl}")
	private String dburl;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	
@Bean
	public DataSource getDataSource() {
	DriverManagerDataSource	dataSource=new DriverManagerDataSource();
	/*dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
	dataSource.setUrl(env.getProperty("db.dburl"));
	dataSource.setUsername(env.getProperty("db.user"));
	dataSource.setPassword(env.getProperty("db.password"));
		return dataSource;*/
		
	dataSource.setDriverClassName(driverClassName);
	dataSource.setUrl(dburl);
	dataSource.setUsername(user);
	dataSource.setPassword(password);
	return dataSource;
	}
@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate(getDataSource());
		return jdbcTemplate;
		
	}
}
