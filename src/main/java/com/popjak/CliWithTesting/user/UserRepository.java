package com.popjak.CliWithTesting.user;

import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmail(String email);

    void deleteUserById(Integer id);

    User findUserByEmail(String email);

    User findUserById(Integer Id);
}
