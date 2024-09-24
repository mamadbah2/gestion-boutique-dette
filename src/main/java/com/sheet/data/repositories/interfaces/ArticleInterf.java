package com.sheet.data.repositories.interfaces;

import com.sheet.core.repository.interfaces.Repository;
import com.sheet.data.entities.Article;

public interface ArticleInterf extends Repository<Article> {
    public Article getArticle(String reference);
}
