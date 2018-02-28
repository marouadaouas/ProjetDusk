/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Esprit1
 */
public class Ligne_commande {
     
 private int ligne_id;
 private Produit p=new Produit();
 public int quantite;

    public Ligne_commande() {
    }

    public Ligne_commande(int ligne_id, int quantite) {
        this.ligne_id = ligne_id;
        this.quantite = quantite;
    }

    public Ligne_commande(int ligne_id, int quantite,Produit p) {
        this.ligne_id = ligne_id;
        this.quantite = quantite;
        this.p=p;
    }

    public int getLigne_id() {
        return ligne_id;
    }

    public void setLigne_id(int ligne_id) {
        this.ligne_id = ligne_id;
    }

    public Produit getP() {
        return p;
    }

    public void setP(Produit p) {
        this.p = p;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ligne_id;
        hash = 17 * hash + Objects.hashCode(this.p);
        hash = 17 * hash + this.quantite;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ligne_commande other = (Ligne_commande) obj;
        if (this.ligne_id != other.ligne_id) {
            return false;
        }
        if (this.quantite != other.quantite) {
            return false;
        }
        if (!Objects.equals(this.p, other.p)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ligne_commande{" + "ligne_id=" + ligne_id + ", p=" + p + ", quantite=" + quantite + '}';
    }
 
 
 
    
}
