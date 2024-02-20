package com.ecommerce.ecom.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecom.entity.User;
import com.ecommerce.ecom.enums.UserRol;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>
{
    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRol admin);

}
