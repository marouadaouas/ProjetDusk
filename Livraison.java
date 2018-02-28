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
public class Livraison {
    public int id_livraison;
    public Date date_livraison;
    public int adresse_livraison;
    public int id_livraison_commande;

    public Livraison(int id_livraison, Date date_livraison, int adresse_livraison, int id_livraison_commande) {
        this.id_livraison = id_livraison;
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.id_livraison_commande = id_livraison_commande;
    }

    public Livraison(Date date_livraison, int adresse_livraison, int id_livraison_commande) {
        this.date_livraison = date_livraison;
        this.adresse_livraison = adresse_livraison;
        this.id_livraison_commande = id_livraison_commande;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }

    public int getAdresse_livraison() {
        return adresse_livraison;
    }

    public void setAdresse_livraison(int adresse_livraison) {
        this.adresse_livraison = adresse_livraison;
    }

    public int getId_livraison_commande() {
        return id_livraison_commande;
    }

    public void setId_livraison_commande(int id_livraison_commande) {
        this.id_livraison_commande = id_livraison_commande;
    }

    @Override
    public String toString() {
        return "Livraison{" + "id_livraison=" + id_livraison + ", date_livraison=" + date_livraison + ", adresse_livraison=" + adresse_livraison + ", id_livraison_commande=" + id_livraison_commande + '}';
    }
    
    
    
}
