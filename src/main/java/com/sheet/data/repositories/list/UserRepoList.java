package com.sheet.data.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.User;
import com.sheet.data.repositories.RepositoryListImpl;
import com.sheet.data.repositories.interfaces.UserInterf;

public class UserRepoList extends RepositoryListImpl<User> implements UserInterf {
    private List<User> users = new ArrayList<User>();
    
    public User getUser(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    
}
