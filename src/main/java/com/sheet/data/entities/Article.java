package com.sheet.data.entities;

public class Article {
    private String reference;
    private String libelle;
    private double prix;
    private int quantiteStock;

    public Article() {
    }

    public Article(String reference, String libelle, double prix, int quantiteStock) {
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
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
