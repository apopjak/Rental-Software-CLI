package com.popjak.RantalCarCLI.user;

import java.util.List;

public interface UserDAO e{
    // crud

    // insert
    void insertUserIntoDB(User user);

    // read
    List<User> showAllUsers();

    User findUserById(Integer Id);

    boolean existUserByEmail(String email);
}
