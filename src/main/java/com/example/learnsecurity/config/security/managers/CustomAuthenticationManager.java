package com.example.learnsecurity.config.security.managers;

import com.example.learnsecurity.config.security.providers.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

    private CustomAuthenticationProvider authenticationProvider;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authenticationProvider.supports(authentication.getClass())) {
            return authenticationProvider.authenticate(authentication);
        }
        throw new BadCredentialsException("Authentication Manager Exception");
    }
}
