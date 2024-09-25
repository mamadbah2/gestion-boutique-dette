package com.sheet.data.entities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class User {
    private String login;
    private String password;
    private String firstname;
    private String lastname;
    private String role;
    private boolean active = true;
    private Role role2;
    private Client client;
    public Role getRole2() {
        return role2;
    }

    public void setRole2(Role role2) {
        this.role2 = role2;
    }


    public User() {
    }

    public User(String login, String password, String firstname, String lastname, boolean  active) {
        this.login = login;
        this.password = hashPassword(password);
        this.firstname = firstname;
        this.lastname = lastname;
        this.role2.getId();
        this.active = active;
    }

    public User(String login, String firstname, String lastname, boolean active) {
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.active = active;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        return lastname != null ? lastname.equals(user.lastname) : user.lastname == null;
    }

}
