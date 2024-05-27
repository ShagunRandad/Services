package com.exam.portal.Configurattion;



import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.portal.service.impl.UserDetailsServiceImpl;
import com.exam.portal.util.JwtUtils;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter {
	 
	private final UserDetailsService userDetailsService;

	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	    // Fetch token from request
	    var jwtTokenOptional = getTokenFromRequest(request);

	    // Validate jwt token -> JWT utils
	    jwtTokenOptional.ifPresent(jwtToken -> {
	      if (JwtUtils.validateToken(jwtToken)) {
	        // Get username from jwt token
	        var usernameOptional = JwtUtils.getUsernameFromToken(jwtToken);

	        usernameOptional.ifPresent(username -> {
	          // Fetch user details with the help of username
	          var userDetails = userDetailsService.loadUserByUsername(username);

	          // Create Authentication token
	          var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	          authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

	          // Set authentication token to Security Context
	          SecurityContextHolder.getContext()
	              .setAuthentication(authenticationToken);
	        });
	      }
	    });

	    // Pass request and response to next filter
	    filterChain.doFilter(request, response);
	  }

	  private Optional<String> getTokenFromRequest(HttpServletRequest request) {
	    // Extract authentication header
	    var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

	    // Bearer <JWT TOKEN>
	    if (StringUtils.isNotBlank(authHeader) && authHeader.startsWith("Bearer ")) {
	      return Optional.of(authHeader.substring(7));
	    }

	    return Optional.empty();
	  }
	
	

}
