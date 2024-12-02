package com.sheet.views;

import java.util.List;
import java.util.Scanner;

import com.sheet.data.entities.Client;
import com.sheet.data.entities.Role;
import com.sheet.data.entities.User;
import com.sheet.services.ClientServ;
import com.sheet.services.UserServ;

public class UserView {
    private Scanner scanner;
    private ClientServ clientServ;
    private UserServ userServ;

    public UserView(Scanner scanner, UserServ userServ, ClientServ clientServ) {
        this.scanner = scanner;
        this.userServ = userServ;
        this.clientServ = clientServ;   
    }
    
    public User saisieFromClient() {
        User u = new User();

        System.out.println("Rechercher le client (name) : ");
        Client cl = clientServ.searchClient(scanner.nextLine());
        if (cl == null) {
            System.out.println("Pas de client sous ce nom");
            return null;
        }

        System.out.println("Login : "+ cl.getName());
        u.setLogin(cl.getName());

        System.out.println("Firstname : ");
        u.setFirstname(scanner.nextLine());

        System.out.println("Lastname : ");
        u.setLastname(scanner.nextLine());

        System.out.println("Password : ");
        u.setPassword(scanner.nextLine());

        System.out.println("Role : user");

        Role role = new Role();
        role.setRole("user");
        u.setRole(role);

        u.setClient(cl);

        return u;
    }

    public User saisie() {
        User u = new User();

        System.out.println("Login : ");
        String login = scanner.nextLine();
        User oldUser = userServ.searchUser(login);
        if (oldUser != null) {
            System.out.println("Login existe deja");
            return null;
        }
        u.setLogin(login);

        System.out.println("Firstname : ");
        u.setFirstname(scanner.nextLine());

        System.out.println("Lastname : ");
        u.setLastname(scanner.nextLine());

        System.out.println("Password : ");
        u.setPassword(scanner.nextLine());

        System.out.println("Role : ");
        System.out.println("1. user");
        System.out.println("2. admin");
        int choice = scanner.nextInt();
        scanner.nextLine();
        Role role = new Role();
        if (choice == 1) {
            role.setRole("user");
        } else if (choice == 2) {
            role.setRole("admin");
        } else {
            System.out.println("Choix invalide");
            return null;
        }
        u.setRole(role);


        return u;
    }

    public String ActiveOrDesactive() {
        System.out.println("Login : ");
        String login = scanner.nextLine();
        User user = userServ.searchUser(login);
        if (user == null) {
            System.out.println("User n'existe pas");
            return "";
        }
        if (user.isActive()) {
            System.out.println("Desactiver le compte de "+login+" ?");
        } else {
            System.out.println("Activer le compte de "+login+" ?");
        }
        System.out.println("(O/n)");
        String choice = scanner.nextLine();
        if (choice.equals("O")) {
            return login;
        }
        return "";
    }

    public String saisieLogin() {
        System.out.println("Login : ");
        String name = scanner.nextLine();
        return name;
    }

    public void showUsers(List<User> users) {
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }
}
