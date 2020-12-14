package org.portfolio.instaorganize.repository;

import org.portfolio.instaorganize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
