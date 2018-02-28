/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Ligne_commande;
import Entities.Produit;
import Utils.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Esprit1
 */
public class ServiceLigne_commande {
    
    
    private static ServiceLigne_commande instance;
    
    public static ServiceLigne_commande getInstance()
    {
        if (instance ==null)
        {
            instance=new ServiceLigne_commande();
        }
        return instance;
    }
    
    public void insert(Ligne_commande c) 
     {
         DataSource d=DataSource.getInstance();
         String req="insert into `ligne_commande` values(?,?,?)";
         
            PreparedStatement ste;
        try {
            ste = d.getConnection().prepareStatement(req);
        
            ste.setInt(5,c.getLigne_id());
            ste.setInt(4,c.getP().id_produit);
            ste.setInt(5,c.getQuantite());
            
            
           
           ste.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Probleme de connexion"+ex.getMessage());
        }
        
     }
    public static List<Ligne_commande> show()
     {
         List<Ligne_commande> l=new ArrayList();
         DataSource d=DataSource.getInstance();
         
         
         String req="select* from  `ligne_commande`";
         
         
        try {
            
            Statement ste=d.getConnection().createStatement();
            
           ResultSet result= ste.executeQuery(req);
            
           while(result.next()){
               
               int ligne_id=result.getInt("ligne_id");
               int quantite=result.getInt("quantite");
               
               int id_produit=result.getInt("id_produit");
               
               
               
               Produit p=new Produit(id_produit);
               l.add(new Ligne_commande(ligne_id,quantite,p));
           }
            
        } catch (SQLException ex) {
            System.err.println("probleme"+ex.getMessage());
        }
       return l;
}
     
     
      public void delete(int ligne_id)
     {
         DataSource d=DataSource.getInstance();
         
         String req="delete from `ligne_commande` where ligne_id='"+ligne_id+"' ";
                 
        try {
            
            Statement ste=d.getConnection().createStatement();
            ste.executeUpdate(req);
            
            
        } catch (SQLException ex) {
            System.err.println("Probleme de connexion");
            System.out.println(ex.getMessage());
        }  
         
         
     }
      
      
     public static void update(int quantite,int ligne_id)
     {
         DataSource d=DataSource.getInstance();
         
         
         String req="UPDATE `ligne_commande`  SET "
                                        +"quantite='"+quantite
                                        +"'WHERE `ligne_id`="+ligne_id ;
         
        try {
            
            Statement ste=d.getConnection().createStatement();
            ste.executeUpdate(req);
            
            
        } catch (SQLException ex) {
            System.err.println("Probleme de connexion");
            System.out.println(ex.getMessage());
        }       
         
     }  
     
    
    
}
