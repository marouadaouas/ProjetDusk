/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Entities.Utilisateur;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kais
 */
public class ServiceUtilisateur {
    
    public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceUtilisateur()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void AjouterUtilisateur (Utilisateur u ) throws SQLException
    {
        String req="INSERT INTO `utilisateur`(`nom`, `prenom`, `age`, `adresse_u`, `email`,"
                + " `num_tel`, `login`, `password`, `enligne`, `etat`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        
        pre.setString(1,u.getNom()); 
        pre.setString(2,u.getPrenom());
        pre.setInt(3,u.getAge());
        pre.setInt(4,u.getAdresse_u());
        pre.setString(5,u.getEmail()); 
        pre.setLong(6,u.getNum_tel());
        pre.setString(7,u.getLogin());
        pre.setString(8,u.getPassword());
        pre.setString(9,u.getEnligne()); 
        pre.setString(10,u.getEtat());
        
        
        
        pre.executeUpdate();
        
        System.out.println("Utilisateur Ajoutée");
    }
 
    
    public  void updateUtilisateur(Utilisateur u,int id)throws SQLException
        {
              
                 String req = "UPDATE `utilisateur` SET `nom`=?,`prenom`=?,"
                         + "`age`=?,`adresse_u`=?,`email`=?,`num_tel`=?,`login`=?,`password`=?,"
                         + "`enligne`=?,`etat`=?WHERE id_u=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                  pre.setString(1,u.getNom()); 
                  pre.setString(2,u.getPrenom());
                  pre.setInt(3,u.getAge());
                  pre.setInt(4,u.getAdresse_u());
                  pre.setString(5,u.getEmail()); 
                  pre.setLong(6,u.getNum_tel());
                  pre.setString(7,u.getLogin());
                  pre.setString(8,u.getPassword());
                  pre.setString(9,u.getEnligne()); 
                  pre.setString(10,u.getEtat());
                  pre.setInt(11,id);
                  
                 pre.executeUpdate();
                 System.out.println("Utilisateur mise à jour"); 
        } 
           
    
    
     public  void supprimerUtilisateur( int id) throws SQLException
        {
                 String req = "DELETE FROM `utilisateur` WHERE id_u="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("Utilisateur Supprimée");
        }
    
     
      public  List<Utilisateur> selectUtilisateur() throws SQLException
      {
       List<Utilisateur> list=new ArrayList<>();
         
            String req="SELECT * FROM utilisateur";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Utilisateur u= new Utilisateur(result.getString("nom"), 
                 result.getString("prenom"),
                 result.getInt("age"),
                 result.getInt("adresse_u"),
                 result.getString("email"),
                 result.getLong("num_tel"),
                 result.getString("login"),
                 result.getString("password"),
                 result.getString("enligne"), 
                 result.getString("etat"));
                 
            list.add(u);
            }
           
       return list;
      }

  public Utilisateur findById(int id_u) {
           
        Utilisateur user = null;
        String req = "select * from utilisateur where id_u =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, id_u);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Utilisateur u= new Utilisateur(resultSet.getString("nom"), 
                 resultSet.getString("prenom"),
                 resultSet.getInt("age"),
                 resultSet.getInt("adresse_u"),
                 resultSet.getString("email"),
                 resultSet.getLong("num_tel"),
                 resultSet.getString("login"),
                 resultSet.getString("password"),
                 resultSet.getString("enligne"), 
                 resultSet.getString("etat"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    }
     

