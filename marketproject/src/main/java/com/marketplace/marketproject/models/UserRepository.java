package com.marketplace.marketproject.models;
import com.marketplace.marketproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}