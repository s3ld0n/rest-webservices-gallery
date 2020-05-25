package com.artisan.solutions.gallery.web.errors;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.function.Supplier;

public class UserNotFoundException extends UsernameNotFoundException implements Supplier {

    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public Object get() {
        return null;
    }
}
