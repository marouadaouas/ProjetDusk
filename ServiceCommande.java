/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Commande;
import Entities.Produit;
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
 * @author Esprit1
 */
public class ServiceCommande {
     public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceCommande()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AjouterCommande (Commande c ) throws SQLException
    {
        String req="INSERT INTO `commande`(`date_commande`, `etat_commande`, `prix_commande`, `quantite_commande`, `id_commande_user` ) "
                + "VALUES (?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setDate(1, c.getDate_commande());
        pre.setString(2, c.getEtat_commande());
        pre.setFloat(3,c.getPrix_commande());
         pre.setInt(4,c.getQuantite_commande());
        pre.setInt(5, c.getId_commande_user());
       
         
        
        pre.executeUpdate();
        
        System.out.println("commande  Ajoutée");
    }

    public  void updateCommande(Commande c,int id)throws SQLException
        {
              
                 String req = "UPDATE `commande` SET `date_commande`=?,`etat_commande`=?,`prix_commande`=?,`quantite_commande`=?,`id_commande_user`=? where id_commande=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                pre.setDate(1, c.getDate_commande());
        pre.setString(2, c.getEtat_commande());
        pre.setFloat(3,c.getPrix_commande());
         pre.setInt(4,c.getQuantite_commande());
         pre.setInt(5,c.getId_commande_user());
        
        pre.setInt(6,id);
         
                 pre.executeUpdate();
                 System.out.println("commande mise à jour"); 
        } 
           
     public  void supprimerCommande( int id) throws SQLException
        {
                 String req = "DELETE FROM `commande` WHERE id_commande="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("commande Supprimée");
        }
    
     
      public  List<Commande> selectCommande() throws SQLException
      {
       List<Commande> list=new ArrayList<>();
         
            String req="SELECT * FROM commande";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Commande c= new Commande (result.getInt("id_commande"),result.getDate("date_commande")
                    ,result.getString("etat_commande"),result.getFloat("prix_commande"),result.getInt("quantite_commande")
                    ,result.getInt("id_commande_user"));
            list.add(c);
            }
           
       return list;
      }
}
