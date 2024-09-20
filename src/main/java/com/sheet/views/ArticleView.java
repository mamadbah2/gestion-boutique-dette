package com.sheet.views;

import java.util.List;
import java.util.Scanner;

import com.sheet.data.entities.Article;
import com.sheet.services.ArticleServ;

public class ArticleView {
    private Scanner scanner;
    private ArticleServ articleServ;

    public ArticleView(Scanner scanner, ArticleServ articleServ) {
        this.scanner = scanner;
        this.articleServ = articleServ;
    }

    public Article saisie() {
        Article article = new Article();

        System.out.println("Entrer la reference de l'article : ");
        String reference = scanner.nextLine();
        Article oldArticle = articleServ.searchArticle(reference);
        if (oldArticle != null) {
            System.out.println("Article existe deja");
            return null;
        }
        article.setReference(reference);

        System.out.println("Entrer le nom de l'article : ");
        article.setLibelle(scanner.nextLine());

        System.out.println("Entrer le prix de l'article :");
        article.setPrix(scanner.nextDouble());

        System.out.println("Entrer la quantite à stocker de l'article :");
        article.setQuantiteStock(scanner.nextInt());
        scanner.nextLine();
        return article;
    }

    public void showArticles(List<Article> articles) {
        for (Article article : articles) {
            System.out.println(article.toString());
        }
    }

    public Article UpdateQteStock() {
        System.out.println("Entrer la reference de l'article : ");
        String reference = scanner.nextLine();
        Article article = articleServ.searchArticle(reference);
        if (article == null) {
            System.out.println("Article n'existe pas");
            return null;
        }
        System.out.println("Entrer la nouvelle quantite de stock : ");
        article.setQuantiteStock(scanner.nextInt());
        scanner.nextLine();
        return article;
    }
}
