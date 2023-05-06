package com.popjak.RentalCarCLI.adminMenu;

import com.popjak.RentalCarCLI.user.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class ViewAllUsers {

    private UserService userService;

    @Autowired
    public ViewAllUsers(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }


    public void listAllUsers() {
        List<User> users = userService.listOFUsers();
        users.forEach(System.out::println);
    }




}
