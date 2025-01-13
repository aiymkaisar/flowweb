package com.example.flower_web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flower_web.Models.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLoginAndPassword(String login, String password);
}
