package com.sheet;

import java.util.Scanner;

import com.sheet.core.database.DatabaseConfig;
import com.sheet.core.factory.FactoryRepo;
import com.sheet.core.factory.FactoryServ;
import com.sheet.services.ArticleServ;
import com.sheet.services.DetteServ;
import com.sheet.services.UserServ;
import com.sheet.views.ArticleView;
import com.sheet.views.DetteView;
import com.sheet.views.UserView;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // ----------------------------------------------------------------------
    public static int showMenu(Scanner scanner) {
        System.out.println("1 - Creer un compte au client");
        System.out.println("2 - Creer compte (Admin ou Boutiquier)");
        System.out.println("3 - Desactiver ou Activer un compte");
        System.out.println("4 - Afficher les comptes actifs");
        System.out.println("5 - Creer un aticle");
        System.out.println("6 - Afficher les articles");
        System.out.println("7 - Afficher les articles disponibles");
        System.out.println("8 - Mettre à jour quantite stock d'un article");
        System.out.println("9 - Archiver les dettes soldées");
        System.out.println("10 - Quitter");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        // Charger la configuration des bases de données
    DatabaseConfig databaseConfig = new DatabaseConfig();

    // Design Pattern: Factory ----------------------------------------------
    FactoryRepo factoryRepo = new FactoryRepo(databaseConfig.entityManagerFactory().createEntityManager());
    FactoryServ factoryServ = new FactoryServ(
        factoryRepo.getInstanceOfClientRepo(),
        factoryRepo.getInstanceOfUserRepo(),
        factoryRepo.getInstanceOfArticleRepo(),
        factoryRepo.getInstanceOfDetteRepo()
    );

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
            choice = showMenu(scanner);
            switch (choice) {
                case 1 -> userServ.createAccount(userView.saisieFromClient());
                case 2 -> userServ.createAccount(userView.saisie());
                case 3 -> userServ.toggleUser(userView.ActiveOrDesactive());
                case 4 -> userView.showUsers(userServ.findActiveUsers());
                case 5 -> articleServ.createArticle(articleView.saisie());
                case 6 -> articleView.showArticles(articleServ.findArticles());
                case 7 -> articleView.showArticles(articleServ.findArticlesDisponible());
                case 8 -> articleServ.updateArticle(articleView.UpdateQteStock());
                case 9 -> detteServ.ArchivedDette(detteView.ArchivedValidateDette());
                case 10 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide");
            }

        } while (choice != 10);
    }
}