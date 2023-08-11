package com.example.learnsecurity.config.security.filter;

import com.example.learnsecurity.config.security.authentications.CustomAuthentication;
import com.example.learnsecurity.config.security.managers.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // create an authentication (Custom authentication)
        // delegate this authentication to the Authentication manager
        // if the authentication is authenticated then get the next filter in the chain
        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication ca = new CustomAuthentication(false, key);

        var a = authenticationManager.authenticate(ca);

        if (a.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }

    }
}
