package com.sheet.data.repositories.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import com.sheet.core.database.DatabaseImpl;
import com.sheet.data.entities.Article;
import com.sheet.data.repositories.interfaces.ArticleInterf;

public class ArticleRepoDB extends DatabaseImpl implements ArticleInterf {

    public ArticleRepoDB() {
        try {
            this.getConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void add(Article article) {
        String req = String.format(
                "Insert into article (reference, libelle, prix, qteStock) values ('%s', '%s', %d, %d)",
                article.getReference(), article.getLibelle(), article.getPrix(), article.getQuantiteStock());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void remove(Article article) {
        String req = String.format("Delete from article where reference = '%s'", article.getReference());
        try {
            this.initPreparedStatement(req);
            this.ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void set(List<Article> object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = new ArrayList<>();
        String req = "Select * from article";
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                articles.add(this.convertToObject(rs));
            }
        } catch (SQLException e) {
        }


        return articles;
    }

    @Override
    public Article getArticle(String reference) {
        String req = String.format("Select * from article where reference = '%s'", reference);
        try {
            this.initPreparedStatement(req);
            ResultSet rs = this.ps.executeQuery();
            if (rs.next()) {
                Article article = this.convertToObject(rs);
                return article;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public Article convertToObject(ResultSet rs) {
        try {
            return new Article(rs.getString("reference"), rs.getString("libelle"), rs.getInt("prix"),
            rs.getInt("qteStock"));
        } catch (SQLException e) {
        }
        return null;
    }

}
