package com.example.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.security.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

	Optional<Users> findByName(String username);

}
