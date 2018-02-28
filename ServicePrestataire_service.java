/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package Service;


import Entities.Prestataire_service;
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
public class ServicePrestataire_service {
        public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServicePrestataire_service()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePrestataire_service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void AjouterPrestataire_service (Prestataire_service p ) throws SQLException
    {
        String req="INSERT INTO `prestataire_service`( `nom_prest`, `prenom_prest`, `age_prest`, "
                + "`num_tel_prest`, `adresse_prest`, `email_prest`, `login_prest`, `mdp_prest`, `enligne_prest`, "
                + "`etat_prest`, `fonction`, `specialite`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        
        pre.setString(1,p.getNom_prest()); 
        pre.setString(2,p.getPrenom_prest());
        pre.setInt(3,p.getAge_prest());
        pre.setLong(4,p.getNum_tel_prest());
        pre.setInt(5,p.getAdresse_prest()); 
        pre.setString(6,p.getEmail_prest());
        pre.setString(7,p.getLogin_prest());
        pre.setString(8,p.getMdp_prest());
        pre.setString(9,p.getEnligne_prest()); 
        pre.setString(10,p.getEtat_prest());
        pre.setString(11,p.getFonction());
        pre.setString(12,p.getSpecialite());
        
        pre.executeUpdate();
        
        System.out.println("prestataire Ajoutée");
    }
 
    
    public  void updatePrestataire_service( Prestataire_service p,int id)throws SQLException
        {
              
                 String req = "UPDATE `prestataire_service` SET `id_prest`=?,`nom_prest`=?"
                         + ",`prenom_prest`=?,`age_prest`=?,`num_tel_prest`=?,"
                         + "`adresse_prest`=?,`email_prest`=?,`login_prest`=?,"
                         + "`mdp_prest`=?,`enligne_prest`=?,`etat_prest`=?,"
                         + "`fonction`=?,`specialite`=? WHERE id_prest=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
                 pre.setString(1,p.getNom_prest()); 
                 pre.setString(2,p.getPrenom_prest());
                 pre.setInt(3,p.getAge_prest());
                 pre.setLong(4,p.getNum_tel_prest());
                 pre.setInt(5,p.getAdresse_prest()); 
                 pre.setString(6,p.getEmail_prest());
                 pre.setString(7,p.getLogin_prest());
                 pre.setString(8,p.getMdp_prest());
                 pre.setString(9,p.getEnligne_prest()); 
                 pre.setString(10,p.getEtat_prest());
                 pre.setString(11,p.getFonction());
                 pre.setString(12,p.getSpecialite());
                 
                 pre.setInt(13,id);
                 pre.executeUpdate();
                 System.out.println("prestataire mise à jour"); 
        } 
           
    
    
     public  void supprimerPrestataire_service( int id) throws SQLException
        {
                 String req = "DELETE FROM `prestataire_service` WHERE id_prest="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("prestataire Supprimée");
        }
    
     
      public  List<Prestataire_service> selectPrestataire_service() throws SQLException
      {
       List<Prestataire_service> list=new ArrayList<>();
         
            String req="SELECT * FROM prestataire_service";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Prestataire_service p= new Prestataire_service(result.getString("nom_prest"), 
                 result.getString("prenom_prest"),
                 result.getInt("age_prest"),
                 result.getLong("num_tel_prest"),
                 result.getInt("adresse_prest"),
                 result.getString("email_prest"),
                 result.getString("login_prest"),
                 result.getString("mdp_prest"),
                 result.getString("enligne_prest"), 
                 result.getString("etat_prest"),
                 result.getString("fonction"),
                 result.getString("specialite"));
            list.add(p);
            }
           
       return list;
      }
    
}
*/