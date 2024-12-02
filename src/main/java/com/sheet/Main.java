package com.sheet;

import java.util.Scanner;

import com.sheet.core.factory.FactoryServ;
import com.sheet.data.entities.User;
import com.sheet.data.repositories.list.ArticleRepoList;
import com.sheet.data.repositories.list.ClientRepoList;
import com.sheet.data.repositories.list.DetteRepoList;
import com.sheet.data.repositories.list.UserRepoList;
import com.sheet.services.ArticleServ;
import com.sheet.services.DetteServ;
import com.sheet.views.DetteView;
import com.sheet.services.UserServ;
import com.sheet.views.ArticleView;
import com.sheet.views.UserView;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static int showMenuRole(Scanner scanner) {
        System.out.println("=== Bienvenue dans l'application de gestion ===");
        System.out.println("Veuillez choisir un rôle :");
        System.out.println("1. Admin");
        System.out.println("2. Boutiquier");
        System.out.println("3. Client");
        System.out.println("0. Quitter");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static int showMenuAdmin(Scanner scanner) {
        System.out.println("\n=== Menu Admin ===");
        System.out.println("1. Créer un utilisateur");
        System.out.println("2. Activer/Désactiver un compte utilisateur");
        System.out.println("3. Créer un article");
        System.out.println("4. Lister les articles (filtrer par disponibilité)");
        System.out.println("5. Mettre à jour la quantité d'un article");
        System.out.println("6. Archiver les dettes soldées");
        System.out.println("7. Lister les utilisateurs");
        System.out.println("0. Retour");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void actionMenuAdmin(int choice, UserServ userServ, UserView userView, ArticleServ articleServ, ArticleView articleView, DetteView detteView, DetteServ detteServ) { 
        switch (choice) {
            case 1:
                User user = userView.saisie();
                userServ.createAccount(user);
                break;
            case 7:
                userView.showUsers(userServ.findAllUsers());
                break;
            case 2:
                String login = userView.saisieLogin();
                if (userServ.searchUser(login) == null) {
                    System.out.println("Utilisateur introuvable");
                    break;
                }
                userServ.toggleUser(login);
                System.out.println("Opération effectuée");
                break;
            case 3:
                articleServ.createArticle(articleView.saisie());
                break;
            case 4:
                articleView.showArticles(articleServ.findArticlesDisponible());
                break;
            case 5:
                articleView.UpdateQteStock();
                break;
            case 6:
                detteServ.ArchivedDette(detteView.ArchivedValidateDette());
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {

        // Design Pattern: Factory ----------------------------------------------
        FactoryServ factoryServ = new FactoryServ(
                new ClientRepoList(),
                new UserRepoList(),
                new ArticleRepoList(),
                new DetteRepoList());

        // ----------------------------------------------------------------------
        // ClientServ clientServ = factory.getInstanceOfClientServ();
        UserServ userServ = factoryServ.getInstanceOfUserServ();
        ArticleServ articleServ = factoryServ.getInstanceOfArticleServ();
        DetteServ detteServ = factoryServ.getInstanceOfDetteServ();
        // ----------------------------------------------------------------------

        UserView userView = new UserView(scanner, userServ, factoryServ.getInstanceOfClientServ());
        ArticleView articleView = new ArticleView(scanner, articleServ);
        DetteView detteView = new DetteView(scanner, detteServ);

        int choice;
        do {
            // choice = showMenu(scanner);
            choice = showMenuRole(scanner);
            switch (choice) {
                case 1:
                    do {
                        int choiceAdmin = showMenuAdmin(scanner);
                        actionMenuAdmin(choiceAdmin, userServ, userView, articleServ, articleView, detteView, detteServ);
                    } while (true);

                default:
                    break;
            }

        } while (choice != 4);
    }
}