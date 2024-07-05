package com.greatlearning.emr.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatlearning.emr.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
