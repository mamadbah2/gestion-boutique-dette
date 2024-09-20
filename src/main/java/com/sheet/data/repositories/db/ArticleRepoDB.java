package com.sheet.data.repositories.db;

import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import com.sheet.data.entities.Article;
import com.sheet.data.repositories.RepositoryDBImpl;
import com.sheet.data.repositories.interfaces.ArticleInterf;

public class ArticleRepoDB extends RepositoryDBImpl<Article> implements ArticleInterf {

    @Override
    public void add(Article article) {
        String req = String.format(
                "Insert into article (reference, libelle, prix, qteStock) values ('%s', '%s', %d, %d)",
                article.getReference(), article.getLibelle(), article.getPrix(), article.getQuantiteStock());
        executeUpdate(req);
    }

    @Override
    public void remove(Article article) {
        String req = String.format("Delete from article where reference = '%s'", article.getReference());
        executeUpdate(req);
    }

    @Override
    public void set(List<Article> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<Article>();
        String req = "Select * from article";
        try {
            ResultSet rs = executeSelect(req);
            while (rs.next()) {
                Article article = new Article(rs.getString("reference"), rs.getString("libelle"), rs.getInt("prix"),
                        rs.getInt("qteStock"));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    @Override
    public Article getArticle(String reference) {
        String req = String.format("Select * from article where reference = '%s'", reference);
        try {
            ResultSet rs = executeSelect(req);
            if (rs.next()) {
                return new Article(rs.getString("reference"), rs.getString("libelle"), rs.getInt("prix"),
                        rs.getInt("qteStock"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
