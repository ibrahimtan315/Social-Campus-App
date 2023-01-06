package com.socialCampusApplication.demo.repository;

import com.socialCampusApplication.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

// database ile haberlesme