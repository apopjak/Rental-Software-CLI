package com.popjak.user;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    File accessToFile(String path) throws IOException;
    List<User> selectAllUsers();
    void addToCSV(User user);



}



