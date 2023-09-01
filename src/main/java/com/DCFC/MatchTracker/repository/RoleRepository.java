package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.ERole;
import com.DCFC.MatchTracker.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
