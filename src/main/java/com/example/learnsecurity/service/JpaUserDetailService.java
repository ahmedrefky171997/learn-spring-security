package com.example.learnsecurity.service;

import com.example.learnsecurity.model.SecurityUser;
import com.example.learnsecurity.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JpaUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username);
        return user
                .map(SecurityUser::new)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Username Not found" + username)
                );
    }
}
