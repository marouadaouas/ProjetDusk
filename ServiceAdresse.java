/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Service;

import Entities.Adresse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author Kais
 */
/*
public class ServiceAdresse {
      
    public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceAdresse()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAdresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void AjouterAdresse (Adresse a ) throws SQLException
    {
        String req="INSERT INTO `adresses`(`titre`, `ville`, `rue`, `code_postal`) "
                + "VALUES (?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setString(1,a.getTitre());
        pre.setString(2,a.getVille()); 
        pre.setString(3,a.getRue());
        pre.setInt(4,a.getCode_postal());
        
        pre.executeUpdate();
        
        System.out.println("Adresse Ajoutée");
    }
 
    
    public  void updateAdresse( Adresse a,int id)throws SQLException
        {
              
                 String req = "UPDATE `adresses` SET `titre`=?,`ville`=?,`rue`=?,`code_postal`=? where id_adresses=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                 pre.setString(1,a.getTitre());
                 pre.setString(2,a.getVille()); 
                 pre.setString(3,a.getRue());
                 pre.setInt(4,a.getCode_postal());
                 pre.setInt(5,id);
                 pre.executeUpdate();
                 System.out.println("Adresse mise à jour"); 
        } 
           
    
    
     public  void supprimerAdresse( int id) throws SQLException
        {
                 String req = "DELETE FROM `adresses` WHERE id_adresses="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("Adresse Supprimée");
        }
    
     
      public  List<Adresse> selectAdresse() throws SQLException
      {
       List<Adresse> list=new ArrayList<>();
         
            String req="SELECT * FROM adresses";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Adresse a= new Adresse (result.getInt("id_adresses"),result.getString("titre")
                    ,result.getString("ville"),result.getString("rue"),result.getInt("code_postal"));
            list.add(a);
            }
           
       return list;
      }
    
}
*/