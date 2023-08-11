package com.example.learnsecurity.model;

import com.example.learnsecurity.model.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityUserAuthority implements GrantedAuthority {

    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getAuthorityName();
    }
}
