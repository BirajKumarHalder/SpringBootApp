package com.tutorials.security;

import com.tutorials.services.impls.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private AuthServiceImpl authService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        Optional.ofNullable(httpServletRequest.getHeader("Authorization"))
                .filter(authorization -> authorization.startsWith("Bearer "))
                .ifPresent(authorization -> {
                    Optional.ofNullable(authService.validateToken(authorization.substring(7)))
                            .ifPresent(userModel -> {
                                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                                        userModel, null, Arrays.asList(new SimpleGrantedAuthority(userModel.getUserRole())));
                                usernamePasswordAuthenticationToken
                                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                            });
                });
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
