/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Commande;
import Entities.Livraison;
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
public class ServiceLivraison {
    public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceLivraison()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceLivraison.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AjouterLivraison (Livraison l ) throws SQLException
    {
        String req="INSERT INTO `livraison`(`date_livraison`, `adresse_livraison`, `id_livraison_commande` ) "
                + "VALUES (?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setDate(1, l.getDate_livraison());
        pre.setInt(2, l.getAdresse_livraison());
        pre.setInt(3,l.getId_livraison_commande());
        
       
         
        
        pre.executeUpdate();
        
        System.out.println("livraison  Ajoutée");
    }

    public  void updateLivraison(Livraison l,int id)throws SQLException
        {
              
                 String req = "UPDATE `livraison` SET `date_livraison`=?,`adresse_livraison`=?,`id_livraison_commande`=? where id_livraison=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                 pre.setDate(1, l.getDate_livraison());
        pre.setInt(2, l.getAdresse_livraison());
        pre.setInt(3,l.getId_livraison_commande());
        
       
        
        pre.setInt(4,id);
         
                 pre.executeUpdate();
                 System.out.println("livraison mise à jour"); 
        } 
           
     public  void supprimerLivraison( int id) throws SQLException
        {
                 String req = "DELETE FROM `livraison` WHERE id_livraison="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("livraison Supprimée");
        }
    
     
      public  List<Livraison> selectLivraison() throws SQLException
      {
       List<Livraison> list=new ArrayList<>();
         
            String req="SELECT * FROM livraison";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Livraison l= new Livraison (result.getInt("id_livraison"),result.getDate("date_livraison")
                    ,result.getInt("adresse_livraison"),result.getInt("id_livraison_commande"));
            list.add(l);
            }
           
       return list;
      }
}
