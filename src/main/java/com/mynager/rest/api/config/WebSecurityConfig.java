package com.mynager.rest.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	private UserDetailsService usDetailsService;
	
	private static final String[] GENERAL_MATCHERS = {"/item", "/item/{id}", "/item/type/{id}",
			"/item/situation/{id}", "/user", "/user/{id}", "/type", "/situation"};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.and()
			.csrf().disable();
		
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.GET, GENERAL_MATCHERS).permitAll()
			.antMatchers(HttpMethod.POST, GENERAL_MATCHERS).permitAll()
			.antMatchers(HttpMethod.PUT, GENERAL_MATCHERS).permitAll()
			.antMatchers(HttpMethod.DELETE, GENERAL_MATCHERS).permitAll()/*.hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/items").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/items", "/user").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.DELETE, "/items", "/user").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")*/
			.anyRequest().authenticated()
			.and().formLogin().permitAll();
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
	
}