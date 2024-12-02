package com.sheet.data.repositories.list;
import com.sheet.data.entities.Article;
import com.sheet.data.repositories.ListImpl;
import com.sheet.data.repositories.interfaces.ArticleInterf;

public class ArticleRepoList extends ListImpl<Article> implements ArticleInterf {

    public ArticleRepoList() {}


    public Article getArticle(String reference) {
        for (Article article : objects) {
            if (article.getReference().equals(reference)) {
                return article;
            }
        }
        return null;
    }

    
}
