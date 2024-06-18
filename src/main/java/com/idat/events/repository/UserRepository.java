package com.idat.events.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idat.events.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);

}