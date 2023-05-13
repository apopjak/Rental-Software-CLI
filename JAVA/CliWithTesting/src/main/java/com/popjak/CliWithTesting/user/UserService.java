package com.popjak.CliWithTesting.user;

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
    public User findUserById(Integer Id) {
        if (existsById(Id)) {
            System.out.println("❌ This ID not in DB");
            return null;
        }
        return userRepository.findUserById(Id);
    }

    @Override
    @Transactional
    public void insertToDB(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean emailExistsInDbAlready(String string) {
        return userRepository.existsByEmail(string);
    }

    @Override
    public boolean existsById(Integer Id) {
        return userRepository.existsById(Id);
    }

    @Override
    @Transactional
    public int removeUserById(Integer Id) {
        if (!userRepository.existsById(Id)) {
            System.out.println("❌ This ID not in DB");
            return 0;
        }
        User user = userRepository.findUserById(Id);
        userRepository.delete(user);
        return 1;
    }
}
