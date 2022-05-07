package com.peaksoft.SpringSecurityMVCToken.repository;

import com.peaksoft.SpringSecurityMVCToken.models.securityModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
