package com.sheet.data.repositories.list;

import java.util.ArrayList;
import java.util.List;

import com.sheet.data.entities.Article;
import com.sheet.data.repositories.RepositoryListImpl;
import com.sheet.data.repositories.interfaces.ArticleInterf;

public class ArticleRepoList extends RepositoryListImpl<Article> implements ArticleInterf {
    private List<Article> articles = new ArrayList<Article>();

    public ArticleRepoList() {}


    public Article getArticle(String reference) {
        for (Article article : articles) {
            if (article.getReference().equals(reference)) {
                return article;
            }
        }
        return null;
    }

    
}
