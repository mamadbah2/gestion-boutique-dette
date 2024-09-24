package com.sheet.data.repositories.interfaces;

import com.sheet.core.repository.interfaces.Repository;
import com.sheet.data.entities.User;

public interface UserInterf extends Repository<User> {
    public User getUser(String login);
}
