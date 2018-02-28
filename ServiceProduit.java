/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Parapharmacie;
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
public class ServiceProduit {
    
       private static ServiceProduit instance;
    public static ServiceProduit getInstance()
    {
        if (instance ==null)
        {
            instance=new ServiceProduit();
        }
        return instance;
    }
     
    public Connection con=DataSource.getInstance().getConnection();
    public Statement ste;
    
    
    public ServiceProduit()
    {
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void AjouterProduit (Produit p ) throws SQLException
    {
        String req="INSERT INTO `produit`(`prix_produit`, `quantite_produit`, `description_produit`, `categorie_produit`, `id_produit_user`, `img_produit`) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement pre= con.prepareStatement(req);
        
        pre.setFloat(1, p.getPrix_produit());
        
        pre.setInt(2, p.getQuantite_produit());
         pre.setString(3, p.getDescription_produit());
        pre.setString(4,p.getCategorie_produit());
        pre.setInt(5, p.getId_produit_user());
         pre.setString(6, p.getImg_produit());
        
       
         
        
        pre.executeUpdate();
        
        System.out.println("produit  Ajoutée");
    }

    public  void updateProduit(Produit p,int id)throws SQLException
        {
              
                 String req = "UPDATE `produit` SET `prix_produit`=?,`quantite_produit`=?,`description_produit`=?,`categorie_produit`=?,`id_produit_user`=?,`img_produit`=? where id_produit=?";
                 PreparedStatement pre= con.prepareStatement(req);
                
          pre.setFloat(1, p.getPrix_produit());
        pre.setInt(2, p.getQuantite_produit());
        pre.setString(3, p.getDescription_produit());
         pre.setString(4,p.getCategorie_produit());
        pre.setInt(5, p.getId_produit_user());
         pre.setString(5, p.getImg_produit());
        pre.setInt(6,id);
         
                 pre.executeUpdate();
                 System.out.println("produit mise à jour"); 
        } 
           
     public  void supprimerProduit( int id) throws SQLException
        {
                 String req = "DELETE FROM `produit` WHERE id_produit="+id;
                 Statement pre=con.createStatement();
                 pre.executeUpdate(req);
                  System.out.println("produit Supprimée");
        }
    
     
      public  List<Produit> selectProduit() throws SQLException
      {
       List<Produit> list=new ArrayList<>();
         
            String req="SELECT * FROM produit";
            PreparedStatement ste= con.prepareStatement(req);
            ResultSet result=ste.executeQuery();
            
            while(result.next())
            {
            Produit p= new Produit (result.getInt("id_produit"),result.getFloat("prix_produit")
                    ,result.getInt("quantite_produit"),result.getString("description_produit"),result.getString("categorie_produit")
                    ,result.getInt("id_produit_user"),result.getString("img_produit"));
            list.add(p);
            }
           
       return list;
      }
      
      
      public List<Produit> show()
     {
         List<Produit> l=new ArrayList();
         DataSource d=DataSource.getInstance();
         
         
         String req="select* from  `produit`";
         
         
        try {
            
            Statement ste=d.getConnection().createStatement();
            
           ResultSet result= ste.executeQuery(req);
            
           while(result.next()){
               int id=result.getInt(1); // ou int id=result.getInt("id");
               float prix=result.getFloat("prix_produit");
               int qte=result.getInt("quantite_produit");
               String description=result.getString("description_produit");
               String categorie=result.getString("categorie_produit");
               int id_p_u=result.getInt("id_produit_user");
               String img=result.getString("img_produit");
               
               l.add(new Produit(id,prix,qte,description,categorie
                       ,id_p_u,img));
           }
            
        } catch (SQLException ex) {
            System.err.println("probleme");
        }
         
         
         
         
       return l;  
     }

    public Produit searchByName(String description) {
         DataSource d=DataSource.getInstance();
         Produit p=new Produit();
         
         String req="select * from `produit` where description_produit='"+description+"';";
         
         try {
            
            Statement ste=d.getConnection().createStatement();
            
           ResultSet result1= ste.executeQuery(req);
           
            
            
           while(result1.next()){
               
               int id=result1.getInt("id_produit"); 
               
               float prix_produit=result1.getFloat("prix_produit");
               String description_produit=result1.getString("description_produit");
               String img_produit=result1.getString("img_produit");
               String categorie_produit=result1.getString("categorie_produit");
               
              p.setId_produit(id);
              p.setPrix_produit(prix_produit);
              p.setDescription_produit(description_produit);
              p.setImg_produit(img_produit);
              p.setCategorie_produit(categorie_produit);
             
           }
            
        } catch (SQLException ex) {
            System.err.println("probleme"+ex.getMessage());
        }
         return p;
     }
    
    
     public Produit searchById(int id) {
        Produit p = null;
        String req = "select * from  `produit` where id_produit =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = con.prepareStatement(req);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 p= new Produit(resultSet.getInt("id_produit"), 
                 resultSet.getFloat("prix_produit"),
                 resultSet.getInt("quantite_produit"),
                 resultSet.getString("description_produit"),
                 resultSet.getString("categorie_produit"),
                 resultSet.getInt("id_produit_user"),
                 resultSet.getString("img_produit")
                 );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
     }
    
    
    
}
