package com.sheet;

import java.util.Scanner;

import com.sheet.data.repositories.interfaces.ArticleInterf;
import com.sheet.data.repositories.interfaces.ClientInterf;
import com.sheet.data.repositories.interfaces.DetteInterf;
import com.sheet.data.repositories.interfaces.UserInterf;
import com.sheet.data.repositories.list.ArticleRepoList;
import com.sheet.data.repositories.list.ClientRepoList;
import com.sheet.data.repositories.list.DetteRepoList;
import com.sheet.data.repositories.list.UserRepoList;
import com.sheet.services.ArticleServ;
import com.sheet.services.ClientServ;
import com.sheet.services.DetteServ;
import com.sheet.services.UserServ;
import com.sheet.views.ArticleView;
import com.sheet.views.DetteView;
import com.sheet.views.UserView;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
   

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
        // Design Pattern: Factory ----------------------------------------------
        ClientInterf clientRepo = new ClientRepoList();
        UserInterf userRepo = new UserRepoList();
        ArticleInterf articleRepo = new ArticleRepoList();
        DetteInterf detteRepo = new DetteRepoList();
        // ----------------------------------------------------------------------
        ClientServ clientServ = new ClientServ(clientRepo);
        UserServ userServ = new UserServ(userRepo);
        ArticleServ articleServ = new ArticleServ(articleRepo);
        DetteServ detteServ = new DetteServ(detteRepo);
        // ----------------------------------------------------------------------
        UserView userView = new UserView(scanner, userServ, clientServ);
        ArticleView articleView = new ArticleView(scanner, articleServ);
        DetteView detteView = new DetteView(scanner, detteServ);

        int choice;
        do {
            choice = showMenu(scanner);
            switch (choice) {
                case 1:
                    userServ.createAccount(userView.saisieFromClient());
                    break;
                case 2 :
                    userServ.createAccount(userView.saisie());
                    break;
                case 3:
                    userServ.toggleUser(userView.ActiveOrDesactive());
                    break;
                case 4:
                    userView.showUsers(userServ.findActiveUsers());
                    break;
                case 5:
                    articleServ.createArticle(articleView.saisie());
                    break;
                case 6:
                    articleView.showArticles(articleServ.findArticles());
                    break;
                case 7:
                    articleView.showArticles(articleServ.findArticlesDisponible());
                    break;
                case 8:
                    articleServ.updateArticle(articleView.UpdateQteStock());
                    break;
                case 9:
                    detteServ.ArchivedDette(detteView.ArchivedValidateDette());
                    break;
                case 10:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }

            
        } while (choice != 10);
    }
}