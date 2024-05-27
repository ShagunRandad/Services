package com.exam.portal.Configurattion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityFilterChainConfig  {
	
	  private final AuthenticationEntryPoint authenticationEntryPoint;
	  private final JWTAuthenticationFilter jwtAuthenticationFilter;

	  public SecurityFilterChainConfig(AuthenticationEntryPoint authenticationEntryPoint, JWTAuthenticationFilter jwtAuthenticationFilter) {
	    this.authenticationEntryPoint = authenticationEntryPoint;
	    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
	  }
	
	
	@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpsecurity) throws Exception {
		// Disable Cors
		
		httpsecurity.cors(AbstractHttpConfigurer::disable);
		
		// Disable CSRF
		
		httpsecurity.csrf(AbstractHttpConfigurer::disable);
		
		// Http Request Filter
		
		httpsecurity.authorizeHttpRequests(httpRequestMatcher -> httpRequestMatcher.requestMatchers("/api/auth/login/**").permitAll() 
				.requestMatchers("/api/auth/verify-token/**").permitAll()
				.requestMatchers("/api/auth/sign-up").permitAll()
				.anyRequest().authenticated()
				);
		
		
		  // Authentication Entry Point -> Exception Handler
		
		httpsecurity.exceptionHandling(exceptionHandiling -> 
		exceptionHandiling.authenticationEntryPoint(authenticationEntryPoint));
		
		
		// Set session policy = STATELESS
		httpsecurity.sessionManagement(sessionManagementCustomizer ->
		sessionManagementCustomizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		// Add JWT Authentication Filter
		httpsecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return httpsecurity.build();
		
	}
	
	
	

}
