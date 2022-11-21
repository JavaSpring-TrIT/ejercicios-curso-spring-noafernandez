package com.curso.inicio;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{	
	
	//Definir roles y usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
        .inMemoryAuthentication()
        .withUser("user1")
        	.password("{noop}user1")
    		.roles("INVITADO")
    		.and()
        .withUser("user2")
	      	.password("{noop}user2")
	      	.roles("OPERADOR")
			.and()
		.withUser("user3")
	        .password("{noop}user3")
	        .roles("ADMIN")
	        .and()
		.withUser("user4")
	        .password("{noop}user4")
	        .roles("OPERADOR", "ADMIN");
	}
	
	
	//Definir políticas de seguridad
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.DELETE,"/curso/**").hasAnyRole("ADMIN", "OPERADOR")
		.antMatchers(HttpMethod.PUT,"/curso/**").hasAnyRole("ADMIN", "OPERADOR")
		.antMatchers(HttpMethod.POST,"/curso/**").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/cursos/**").authenticated()	
		.antMatchers(HttpMethod.GET, "/curso/**").authenticated()		
		.and()
		.httpBasic();
	
	}
}
