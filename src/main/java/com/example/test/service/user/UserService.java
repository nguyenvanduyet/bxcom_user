package com.example.test.service.user;

import com.example.test.model.AppUser;
import com.example.test.model.UserPrinciple;
import com.example.test.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IAppUserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<AppUser> showAll() {
        return userRepo.findAll();
    }

    @Override
    public AppUser create(AppUser user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return userRepo.findAppUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOptional = findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }
}
