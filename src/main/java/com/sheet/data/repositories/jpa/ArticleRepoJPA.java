package com.sheet.data.repositories.jpa;

import javax.persistence.*;
import java.sql.ResultSet;

import com.sheet.data.entities.Article;
import com.sheet.data.repositories.interfaces.ArticleInterf;

import java.util.List;

public class ArticleRepoJPA implements ArticleInterf {

    @PersistenceContext
    private EntityManager em;

    // Le constructeur avec l'injection de l'EntityManager
    public ArticleRepoJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void add(Article article) {
        try {
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Article article) {
        try {
            em.getTransaction().begin();
            Article managedArticle = em.merge(article); // Rejoindre le contexte de persistance
            em.remove(managedArticle);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<Article> getAll() {
        try {
            return em.createQuery("SELECT a FROM Article a", Article.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Article getArticle(String reference) {
        try {
            return em.find(Article.class, reference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void set(List<Article> object) {
        // Non implémenté
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }

    @Override
    public Article convertToObject(ResultSet rs) {
        // Non utilisé avec JPA
        throw new UnsupportedOperationException("Method convertToObject not supported with JPA");
    }
}

