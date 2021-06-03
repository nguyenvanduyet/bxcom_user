package com.example.test.repo;

import com.example.test.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<AppUser,Long> {
    Optional <AppUser> findAppUserByUsername(String username);
}
