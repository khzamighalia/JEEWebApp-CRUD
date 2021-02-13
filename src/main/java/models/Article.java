/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Admin
 */
public class Article {
    private int id;
    private String designation;
    private Float prix;
    private int qte;

    public Article(int id, String designation, Float prix, int qte) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.qte = qte;
    }
    
    public Article(String designation, Float prix, int qte) {
        this.designation = designation;
        this.prix = prix;
        this.qte = qte;
    }


    public Article() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", prix=" + prix +
                ", qte=" + qte +
                '}';
    }
}

    
