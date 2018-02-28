/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Parapharmacie;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Esprit1
 */
public class ServicePara {
     public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServicePara()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePara.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AjouterPara (Parapharmacie p ) throws SQLException
    {
        String req="INSERT INTO `parapharmacie`(`nom_para`, `adresse_para`, `num_tel_para`, `email_para`, `horaire_ouverture_para`, `horaire_fermeture_para`, `id_resp_para` ) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setString(1, p.getNom_para());
        pre.setInt(2, p.getAdresse_para());
         pre.setInt(3, p.getNum_tel_para());
        pre.setString(4, p.getEmail_para());
         pre.setTime(5, p.getHoraire_ouverture_para());
        pre.setTime(6, p.getHoraire_fermeture_para());
        pre.setInt(7, p.getId_resp_para());
         
        
        pre.executeUpdate();
        
        System.out.println("para Ajoutée");
    }

    public  void updatePara( Parapharmacie p,int id)throws SQLException
        {
              
                 String req = "UPDATE `parapharmacie` SET `nom_para`=?,`adresse_para`=?,`num_tel_para`=?,`email_para`=?,`horaire_ouverture_para`=?,`horaire_fermeture_para`=?,`id_resp_para`=? where id_para=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                pre.setString(1, p.getNom_para());
        pre.setInt(2, p.getAdresse_para());
         pre.setInt(3, p.getNum_tel_para());
        pre.setString(4, p.getEmail_para());
         pre.setTime(5, p.getHoraire_ouverture_para());
        pre.setTime(6, p.getHoraire_fermeture_para());
        pre.setInt(7, p.getId_resp_para());
        pre.setInt(8,id);
         
                 pre.executeUpdate();
                 System.out.println("para mise à jour"); 
        } 
           
     public  void supprimerPara( int id) throws SQLException
        {
                 String req = "DELETE FROM `parapharmacie` WHERE id_para="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("para Supprimée");
        }
    
     
      public  ObservableList<Parapharmacie> selectPara() throws SQLException
      {
       ObservableList<Parapharmacie> list=FXCollections.observableArrayList();
         
            String req="SELECT * FROM parapharmacie";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Parapharmacie p= new Parapharmacie (result.getInt("id_para"),result.getString("nom_para")
                    ,result.getInt("adresse_para"),result.getInt("num_tel_para"),result.getString("email_para")
                    ,result.getTime("horaire_ouverture_para"),result.getTime("Horaire_fermeture_para")
                    ,result.getInt("id_resp_para"));
            list.add(p);
            }
           
       return list;
      }
       public Parapharmacie findById(int id_para) {
           
        Parapharmacie para = null;
        String req = "select * from parapharmacie where id_para =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, id_para);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 para= new Parapharmacie(resultSet.getString("nom_para"), 
                 resultSet.getInt("adresse_para"),
                 resultSet.getInt("num_tel_para"),
                 resultSet.getString("email_para"),
                 resultSet.getTime("horaire_ouverture_para"),
                 resultSet.getTime("horaire_fermeture_para"),
                 resultSet.getInt("Id_resp_para"));
                 
                        }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        return para;
    }

   public int  returnLast () throws SQLException
    {
       int  last_id = 0 ;
         String req = "SELECT `id_para` FROM parapharmacie ORDER BY `id_para` DESC LIMIT 1 " ;
         PreparedStatement ste= con.prepareStatement(req);
         ResultSet result=ste.executeQuery();
         while(result.next())
            {
           last_id = result.getInt("id_para");
            }
         return last_id ; 
    }
    
}
