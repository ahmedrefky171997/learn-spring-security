package com.example.learnsecurity.config.security.filter;

import com.example.learnsecurity.config.security.authentications.CustomAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Value("${my.key}")
    private String secretKey;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        // create an authentication (Custom authentication)
        // delegate this authentication to the Authentication manager
        // if the authentication is authenticated then get the next filter in the chain
        // if the key isn't there then it's a different authentication paradigm
        String key = request.getHeader("key");

        if (secretKey.equals(key)) {
            SecurityContextHolder.getContext().setAuthentication(new CustomAuthentication(true, key));
        } else {
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request, response);
    }
}
