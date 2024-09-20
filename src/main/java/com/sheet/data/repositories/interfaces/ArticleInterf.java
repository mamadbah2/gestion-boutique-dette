package com.sheet.data.repositories.interfaces;

import com.sheet.data.entities.Article;
import com.sheet.data.repositories.Repository;

public interface ArticleInterf extends Repository<Article> {
    public Article getArticle(String reference);
}
