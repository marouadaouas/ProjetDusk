/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Esprit1
 */
public class Commande {
    public int id_commande;
    public Date date_commande;
    public String etat_commande;
    public float prix_commande;
    public int quantite_commande;
    public int id_commande_user;

    public Commande(float prix_commande, int id_commande_user) {
        this.prix_commande = prix_commande;
        this.id_commande_user = id_commande_user;
    }

    public Commande(String etat_commande, float prix_commande, int quantite_commande, int id_commande_user) {
        this.etat_commande = etat_commande;
        this.prix_commande = prix_commande;
        this.quantite_commande = quantite_commande;
        this.id_commande_user = id_commande_user;
    }

    
    
    public Commande(int id_commande, Date date_commande, String etat_commande, float prix_commande, int quantite_commande, int id_commande_user) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.etat_commande = etat_commande;
        this.prix_commande = prix_commande;
        this.quantite_commande = quantite_commande;
        this.id_commande_user = id_commande_user;
    }

    public Commande(Date date_commande, String etat_commande, float prix_commande, int quantite_commande, int id_commande_user) {
        this.date_commande = date_commande;
        this.etat_commande = etat_commande;
        this.prix_commande = prix_commande;
        this.quantite_commande = quantite_commande;
        this.id_commande_user = id_commande_user;
    }

    public Commande() {
    }

    
    
    
    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public String getEtat_commande() {
        return etat_commande;
    }

    public void setEtat_commande(String etat_commande) {
        this.etat_commande = etat_commande;
    }

    public float getPrix_commande() {
        return prix_commande;
    }

    public void setPrix_commande(float prix_commande) {
        this.prix_commande = prix_commande;
    }

    public int getQuantite_commande() {
        return quantite_commande;
    }

    public void setQuantite_commade(int quantite_commande) {
        this.quantite_commande  = quantite_commande;
    }

    public int getId_commande_user() {
        return id_commande_user;
    }

    public void setId_commande_user(int id_commande_user) {
        this.id_commande_user = id_commande_user;
    }

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", date_commande=" + date_commande + ", etat_commande=" + etat_commande + ", prix_commande=" + prix_commande + ", quantite_commande=" + quantite_commande + ", id_commande_user=" + id_commande_user + '}';
    }
    
    
    
    
}
