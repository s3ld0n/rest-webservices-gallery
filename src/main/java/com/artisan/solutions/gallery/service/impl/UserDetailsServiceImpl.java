package com.artisan.solutions.gallery.service.impl;

import com.artisan.solutions.gallery.configuration.UserPrincipal;
import com.artisan.solutions.gallery.persistence.model.User;
import com.artisan.solutions.gallery.persistence.repository.UserRepository;
import com.artisan.solutions.gallery.web.errors.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                            .findByUsername(username)
                            .orElseThrow(new UserNotFoundException("no such user: " + username));
        return new UserPrincipal(user);
    }
}
