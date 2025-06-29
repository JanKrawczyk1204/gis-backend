package com.template.auth.repository;

import com.template.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByLogin(String login);
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUuid(String uuid);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE (login = ?1 OR email = ?1)")
    Optional<User> findUserByLoginOrEmailAndLockAndEnabled(String loginOrEmail);
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE (login = ?1 OR email = ?1) AND role = 'ADMIN'")
    Optional<User> findUserByLoginOrEmailAndLockAndEnabledAndIsAdmin(String loginOrEmail);
}
