package com.popjak.CliWithTesting.user;

import java.util.*;

public interface UserDAO {

    List<User> listAllUsers();

    User findUserById(Integer Id);

    void insertToDB(User user);

    boolean emailExistsInDbAlready(String string);

    boolean existsById(Integer Id);

    int removeUserById(Integer Id);

    User selectUserByEmail(String email);
}