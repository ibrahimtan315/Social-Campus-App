package com.socialCampusApplication.demo.repository;

import com.socialCampusApplication.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
