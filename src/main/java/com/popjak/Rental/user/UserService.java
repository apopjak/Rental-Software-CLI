package com.popjak.Rental.user;

import jakarta.transaction.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService implements UserDAO {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }


    @Override
    @Transactional
    public void insertToDB(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean checkIfEmailInDB(String email) {
        return userRepository.existsByEmail(email);
    }


    @Override
    @Transactional
    public void removeUserByEmail(String userEmail) {
        userRepository.deleteUserByEmail(userEmail);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUsersByEmail(email);
    }

    @Override
    public void userUpdate(String email, String newFirstName, String newLastName, String newEmail) {
        if (!userRepository.existsByEmail(email)) return;

        User user = getUserByEmail(email);
        User updatedUser = new User(newFirstName,newLastName,newEmail);

        userRepository.delete(user);
        userRepository.save(updatedUser);

    }

}
