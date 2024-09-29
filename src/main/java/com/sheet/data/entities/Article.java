package com.sheet.data.entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import jakarta.persistence.Entity;

@Entity
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private String libelle;
    private int prix;
    private int quantiteStock;
    private List<Dette> dettes;
    
    public Article() {
    }
    
    
    public List<Dette> getDettes() {
        return dettes;
    }

    public void setDettes(List<Dette> dettes) {
        this.dettes = dettes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article(String reference, String libelle, int prix, int quantiteStock) {
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "reference='" + reference + '\'' +
                ", libelle='" + libelle + '\'' +
                ", prix=" + prix +
                ", quantiteStock=" + quantiteStock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return reference.equals(article.reference);
    }
}
