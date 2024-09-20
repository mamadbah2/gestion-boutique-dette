package com.sheet.services;


import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserServ {
    private UserInterf userRepo;

    public UserServ(UserInterf userRepo) {
        this.userRepo = userRepo;
    }

    public void createAccount(User user) {
        if (user != null) {
            userRepo.add(user);
        }
    }

    public User searchUser(String login) {
        return userRepo.getUser(login);
    }

    // S'assurer que le login existe avant d'appeler cette méthode
    public void toggleUser(String login) {
        User user = userRepo.getUser(login);
        userRepo.remove(user);
        if (user != null) {
            user.setActive(!user.isActive());
        }
        userRepo.add(user);
    }

    public List<User> findActiveUsers() {
        List<User> activeUsers = new ArrayList<User>();
        // Programmation déclarative
        userRepo.getAll().stream().filter(user -> user.isActive()).forEach(activeUsers::add);
        return activeUsers;
    }
}
