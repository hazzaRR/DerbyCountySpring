package com.DCFC.MatchTracker.repository;

import com.DCFC.MatchTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
