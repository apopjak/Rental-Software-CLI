package com.popjak.RentalCarCLI.user;


import java.util.List;

public interface UserDAO {
    // crud

    // insert
    void insertUserIntoDB(User user);

    // read
    List<User> showAllUsers();

    User findUserById(Integer Id);

    boolean existUserByEmail(String email);

    List<User> findUserByEmail(String email);
}
