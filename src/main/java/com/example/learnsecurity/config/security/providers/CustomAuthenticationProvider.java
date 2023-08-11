package com.example.learnsecurity.config.security.providers;

import com.example.learnsecurity.config.security.authentications.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${my.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomAuthentication ca = (CustomAuthentication) authentication;

        if (ca.getKey().equals(key)) {
            return new CustomAuthentication(true, key);
        }

        throw new BadCredentialsException("Problem in the Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
