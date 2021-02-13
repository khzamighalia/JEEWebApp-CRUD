/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Article;
import services.SArticleDAO;

/**
 *
 * @author Admin
 */
public class Test {
     public static void main (String[] args) throws SQLException {
        SArticleDAO dao=SArticleDAO.getInstance();
        Article ar=new Article("plante3", (float) 68.01,4);
        Article b=dao.ajouterArticle(new Article("plant4", (float) 68.01,4));
        Article a=dao.ajouterArticle(b);
        a=dao.ajouterArticle(b);
        

        System.out.println(a.toString());
        List<Article> Produits = new ArrayList<Article>();
        Produits=dao.ChercherArticle("plante2");
        for (Article p : Produits){
            System.out.println(p.toString());
        }
        dao.ModifierArticle(26,"plante3",(float)70.7, 10);        
        Produits=dao.AfficherArticles();
        for (Article p : Produits){
            System.out.println(p.toString());
        }
        dao.SupprimerArticle(Produits.get(1).getId());
        Produits=dao.AfficherArticles();
        for (Article p : Produits){
            System.out.println(p.toString());
        }
              

    }
}
