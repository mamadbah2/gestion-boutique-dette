package com.sheet.data.repositories.interfaces;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.Repository;

public interface UserInterf extends Repository<User> {
    public User getUser(String login);
}
