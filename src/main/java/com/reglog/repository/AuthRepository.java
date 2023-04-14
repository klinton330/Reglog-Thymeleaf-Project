package com.reglog.repository;

import com.reglog.entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<RegisterUser,Long> {

    public RegisterUser findByEmail(String email);
}
