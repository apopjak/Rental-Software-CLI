package com.popjak.Rental.user;

import java.util.*;

public interface UserDAO {

    List<User> listAllUsers();

    void insertToDB(User user);

    boolean checkIfEmailInDB(String string);

    void removeUserByEmail(String userEmail);

    User getUserByEmail(String email);

    void userUpdate(String email, String newFirstName, String newLastName, String newEmail);
}