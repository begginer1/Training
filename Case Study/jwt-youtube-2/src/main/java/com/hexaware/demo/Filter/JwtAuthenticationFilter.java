package com.hexaware.demo.Filter;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hexaware.demo.service.JwtService;
import com.hexaware.demo.serviceImpl.UserDetailServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private JwtService jwtService;
	private UserDetailServiceImpl userDetailsService;
	
	


	public JwtAuthenticationFilter(JwtService jwtService, UserDetailServiceImpl userDetailsService) {
		super();
		this.jwtService = jwtService;
		this.userDetailsService = userDetailsService;
	}




//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		String authHeader=request.getHeader("Authorization");
//		if(authHeader==null|| !authHeader.startsWith("Bearer "))
//		{
//			filterChain.doFilter(request, response);
//		return ;
//		}
//		String token=authHeader.substring(7);
//		String username=jwtService.extractUsername(token);
//		if(username!=null &&SecurityContextHolder.getContext().getAuthentication()==null)
//		{
//			UserDetails userDetails=userDetailsService.loadUserByUsername(username);
//			
//			if(jwtService.isValid(token, userDetails))
//			{
//				UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(username,userDetails.getAuthorities());
//			authToken.setDetails(
//					new WebAuthenticationDetailsSource().buildDetails(request));
//			
//			SecurityContextHolder.getContext().setAuthentication(authToken);
//			}
//		}
//		filterChain.doFilter(request, response);
//		
//		
//	}

	@Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
             @NonNull HttpServletResponse response,
             @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request,response);
            return;
        }

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


            if(jwtService.isValid(token, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);


    }
}
