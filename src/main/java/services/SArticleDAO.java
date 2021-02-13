/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connectiondb.Singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Article;
import repositories.IArticleDAO;

/**
 *
 * @author Admin
 */
public class SArticleDAO implements IArticleDAO {
    
     private static SArticleDAO instance;
    public SArticleDAO(){
    }

    public static SArticleDAO getInstance(){
        if(instance==null){
            instance = new SArticleDAO();
        }
        return instance;
    }

     @Override
    public Article ajouterArticle(Article A) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int id=0;
        int state=0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "INSERT INTO Article(designation, prix, qte) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(query_POST, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, A.getDesignation());
            statement.setFloat(2, A.getPrix());
            statement.setInt(3, A.getQte());
            state = statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
          if(rs.next()){
              A.setId(rs.getInt(1));
          }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }

    return A;
    }
    
    @Override
    public List<Article> AfficherArticles() throws SQLException{
           List<Article> Produits = new ArrayList<Article>();
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {
            connection = Singleton.getConnection();
            String query_POST = "SELECT * from Article";
            statement = connection.prepareStatement(query_POST);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Article A = new Article();
                A.setId(rs.getInt(1));
                A.setDesignation(rs.getString(2));
                A.setPrix(rs.getFloat(3));
                A.setQte(rs.getInt(4));
                Produits.add(A);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return  Produits;
    
        
    }
    @Override
    public void SupprimerArticle(int id) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "DELETE from Article WHERE id Like ? ";
            statement = connection.prepareStatement(query_POST);
            statement.setLong(1, id);
            statement.execute();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
 
       
    
     @Override
    public List<Article> ChercherArticle(String name) throws SQLException {
        List<Article> Produits = new ArrayList<Article>();
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "SELECT * from Article WHERE designation Like ? ";
            statement = connection.prepareStatement(query_POST);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Article A = new Article();
                A.setId(rs.getInt(1));
                A.setDesignation(rs.getString(2));
                A.setPrix(rs.getFloat(3));
                A.setQte(rs.getInt(4));
                Produits.add(A);
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return  Produits;
    }
    
    public Article ChercherArticleById(int id) throws SQLException {
        Article A = new Article();
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "SELECT * from Article WHERE id Like ? ";
            statement = connection.prepareStatement(query_POST);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                A.setId(rs.getInt(1));
                A.setDesignation(rs.getString(2));
                A.setPrix(rs.getFloat(3));
                A.setQte(rs.getInt(4));
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return  A;
    }
    
         @Override
    public void ModifierArticle(int id,String designation,Float prix,int qte) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        int state = 0;
        try {

            // check if the User Exists Or Not
            // code goes here ::
            connection = Singleton.getConnection();
            String query_POST = "UPDATE Article SET designation= ? , prix = ? , qte = ? WHERE id = ? ";
            statement = connection.prepareStatement(query_POST);
            statement.setString(1, designation);
            statement.setFloat(2, prix);
            statement.setInt(3, qte);
            statement.setInt(4, id);
            statement.execute();


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
     
    }
    
}
