package com.sheet.data.repositories.list;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.ListImpl;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserRepoList extends ListImpl<User> implements UserInterf {
    
    public User getUser(String login) {
        for (User user : objects) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
}
