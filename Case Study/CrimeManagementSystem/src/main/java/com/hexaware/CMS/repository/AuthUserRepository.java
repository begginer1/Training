package com.hexaware.CMS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.CMS.entity.AuthUser;


 

 @Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    Optional<AuthUser> findByName(String username);
    Boolean existsByEmail(String email);
    Optional<AuthUser> findByUsernameOrEmail(String username, String email);
    Optional<AuthUser> findByUsername(String username);
    Optional<AuthUser> findByEmail(String email);
	Boolean existsByUsername(String username);
}
