package com.example.lab.auth.filter;

import com.example.lab.auth.AuthService;
import com.example.lab.auth.util.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JWTFilter extends OncePerRequestFilter {

    private JWTUtil jwtUtil;
    private AuthService authService;

    @Autowired
    public JWTFilter(JWTUtil jwtUtil, AuthService authService) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.split("")[1];
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractTokenFromRequest(request);
        if (token != null && jwtUtil.isTokenValid(token)) {
            var authDetails = this.authService.loadUserByUsername(jwtUtil.getSubject(token));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authDetails, null, authDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

}
