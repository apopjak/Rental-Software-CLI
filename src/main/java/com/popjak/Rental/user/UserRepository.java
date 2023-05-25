package com.popjak.Rental.user;

import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User getUsersByEmail(String email);

    void deleteUserByEmail(String email);



}
