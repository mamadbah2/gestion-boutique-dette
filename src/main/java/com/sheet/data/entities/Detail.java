package com.sheet.data.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Detail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantite;
    @OneToMany
    private Dette dette;
    @OneToMany
    private Article article;

    public Detail(int quantite, Dette dette, Article article) {
        this.quantite = quantite;
        this.dette = dette;
        this.article = article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Dette getDette() {
        return dette;
    }

    public void setDette(Dette dette) {
        this.dette = dette;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "quantite=" + quantite +
                ", dette=" + dette +
                ", article=" + article +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Detail detail = (Detail) o;

        return quantite == detail.quantite;
    }
}
