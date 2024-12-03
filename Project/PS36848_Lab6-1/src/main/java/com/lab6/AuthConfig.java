package com.lab6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class AuthConfig  {
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected void configure(AuthenticationManagerBuilder auth,BCryptPasswordEncoder pe) throws Exception
	{
		auth.inMemoryAuthentication()
		.withUser("user1").password(pe.encode("123")).roles("GUEST")
		.and()
		.withUser("user2").password(pe.encode("123")).roles("GUEST","USER")
		.and()
		.withUser("user1").password(pe.encode("123")).roles("GUEST","USER","ADMIN");
	}
	
	@Bean
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().cors().disable();
		
		http.authorizeRequests(auth->{
			auth.requestMatchers("/home/index").permitAll()
			.anyRequest().authenticated();
		});
		
	}
}
