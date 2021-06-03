package com.example.test.service.user;

import com.example.test.model.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IAppUserService extends UserDetailsService {
    List<AppUser> showAll();
    AppUser create(AppUser user);
    Optional<AppUser> findByUsername(String username);
}
