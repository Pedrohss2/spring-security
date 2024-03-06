package com.pedro.demo.repositories;

import com.pedro.demo.entities.User;
import com.pedro.demo.projection.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByLogin(String login);

}
