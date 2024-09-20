package com.sheet.services;

import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.Article;
import com.sheet.data.repositories.interfaces.ArticleInterf;

public class ArticleServ {
    private ArticleInterf articleRepo;

    // Constructor
    public ArticleServ(ArticleInterf articleRepo) {
        this.articleRepo = articleRepo;
    }

    public void createArticle(Article article) {
        articleRepo.add(article);
    }

    public Article searchArticle(String reference) {
        return articleRepo.getArticle(reference);
    }

    public List<Article> findArticles() {
        return articleRepo.getAll();
    }

    public List<Article> findArticlesDisponible() {
        List<Article> articlesDispo = new ArrayList<Article>();
        articleRepo.getAll().stream().filter(art -> art.getQuantiteStock() > 0).forEach(articlesDispo::add);
        return articlesDispo;
    }

    public void updateArticle(Article article) {
        articleRepo.remove(article);
        articleRepo.add(article);
    }
}
