/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.CarteBancaire;
import Entities.Commande;
import Entities.Produit;
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
public class ServiceCarteBancaire {
    public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceCarteBancaire()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCarteBancaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AjouterCarteBancaire (CarteBancaire cb ) throws SQLException
    {
        String req="INSERT INTO `carte_bancaire`( `num_carte`, `id_prop_user`, `date_expiration`, `pass_carte`, `solde`, `banque`, `type`) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setInt(1, cb.getNum_carte());
        //pre.setInt(2, cb.getProprietaire().getId_u());
        pre.setInt(2, cb.getId_u());
        pre.setDate(3,cb.getDate_expiration());
         pre.setInt(4,cb.getPass_carte());
        pre.setFloat(5, cb.getSolde());
         pre.setString(6, cb.getBanque());
          pre.setString(7, cb.getType());
       
         
        
        pre.executeUpdate();
        
        System.out.println("carte bancaire  Ajoutée");
    }

    public  void updateCarteBancaire(CarteBancaire cb,int id)throws SQLException
        {
              
                 String req = "UPDATE `carte_bancaire` SET `num_carte`=?,`id_prop_user`=?,`date_expiration`=?,`pass_carte`=?,`solde`=?,`banque`=?,`type`=? where id_carte=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
               pre.setInt(1, cb.getNum_carte());
        pre.setInt(2, cb.getProprietaire().getId_u());
        pre.setDate(3,cb.getDate_expiration());
         pre.setInt(4,cb.getPass_carte());
        pre.setFloat(5, cb.getSolde());
         pre.setString(6, cb.getBanque());
          pre.setString(7, cb.getType());
        
        pre.setInt(8,id);
         
                 pre.executeUpdate();
                 System.out.println("carte bancaire mise à jour"); 
        } 
           
     public  void supprimerCarteBancaire( int id) throws SQLException
        {
                 String req = "DELETE FROM `carte_bancaire` WHERE id_carte="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("carte bancaire Supprimée");
        }
    
     
      public  ObservableList<CarteBancaire> selectCarteBancaire() throws SQLException
      {
          ObservableList<CarteBancaire> list=FXCollections.observableArrayList();
       //List<CarteBancaire> list=new ArrayList<>();
         
            String req="SELECT * FROM carte_bancaire";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
           
            
            while(result.next())
            {
            CarteBancaire cb= new CarteBancaire (result.getInt("num_carte"),new ServiceUtilisateur().findById(result.getInt("id_prop_user"))
                    ,result.getDate("date_expiration"),result.getInt("pass_carte"),result.getFloat("solde")
                    ,result.getString("banque"),result.getString("type"));
            list.add(cb);
            }
           
       return list;
      }
        public CarteBancaire searchById(int id) {
        CarteBancaire cb = null;
        String req = "select * from  `carte_bancaire` where id_carte =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 cb= new CarteBancaire(resultSet.getInt("id_carte"), 
                 resultSet.getInt("num_carte"),
        new ServiceUtilisateur().findById(resultSet.getInt("id_prop_user")),
                 resultSet.getDate("date_expiration"),
                 resultSet.getInt("pass_carte"),
                 resultSet.getFloat("solde"),
                 resultSet.getString("banque"),
                 resultSet.getString("type")
                 );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cb;
     }
    
}
