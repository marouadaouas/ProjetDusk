/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Esprit1
 */
public class Produit {
    public int id_produit ;
    public float prix_produit;
    public int quantite_produit;
    public String description_produit;
    public String categorie_produit;
    public int id_produit_user;
    public String img_produit;

   /* public Produit( String img_produit,float prix_produit, String description_produit,int quantite_produit,String categorie_produit, int id_produit_user) {
        this.prix_produit = prix_produit;
        this.quantite_produit = quantite_produit;
        this.description_produit = description_produit;
        this.categorie_produit = categorie_produit;
        this.id_produit_user = id_produit_user;
        this.img_produit = img_produit;
    }
*/
    
    
    public Produit(int id_produit, float prix_produit, int quantite_produit, String description_produit, String categorie_produit, int id_produit_user, String img_produit) {
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
        this.quantite_produit = quantite_produit;
        this.description_produit = description_produit;
        this.categorie_produit = categorie_produit;
        this.id_produit_user = id_produit_user;
        this.img_produit = img_produit;
    }
    

    public Produit(int id_produit, float prix_produit, int quantite_produit, String description_produit, String categorie_produit, int id_produit_user) {
        this.id_produit = id_produit;
        this.prix_produit = prix_produit;
        this.quantite_produit = quantite_produit;
        this.description_produit = description_produit;
        this.categorie_produit = categorie_produit;
        this.id_produit_user = id_produit_user;
    }

    public Produit(float prix_produit, int quantite_produit, String description_produit, String categorie_produit, int id_produit_user,String img_produit) {
        this.prix_produit = prix_produit;
        this.quantite_produit = quantite_produit;
        this.description_produit = description_produit;
        this.categorie_produit = categorie_produit;
        this.id_produit_user = id_produit_user;
        this.img_produit=img_produit;
    }

    public Produit() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produit(int id_produit) {
        this.id_produit=id_produit;
    }


    public String getImg_produit() {
        return img_produit;
    }

    public void setImg_produit(String img_produit) {
        this.img_produit = img_produit;
    }
  
    
    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public int getQuantite_produit() {
        return quantite_produit;
    }

    public void setQuantite_produit(int quantite_produit) {
        this.quantite_produit=quantite_produit;
    }

    public String getDescription_produit() {
        return description_produit;
    }

    public void setDescription_produit(String description_produit) {
        this.description_produit = description_produit;
    }

    public String getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(String categorie_produit) {
        this.categorie_produit = categorie_produit;
    }

    public int getId_produit_user() {
        return id_produit_user;
    }

    public void setId_produit_user(int id_produit_user) {
        this.id_produit_user = id_produit_user;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", prix_produit=" + prix_produit + ", quantite_produit=" + quantite_produit + ", description_produit=" + description_produit + ", categorie_produit=" + categorie_produit + ", id_produit_user=" + id_produit_user + '}';
    }

    
    
    
}
