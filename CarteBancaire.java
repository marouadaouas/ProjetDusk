/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import Entities.Utilisateur ;

/**
 *
 * @author Esprit1
 */
public class CarteBancaire {
    
    public int id_carte;
    public int num_carte;
    public Utilisateur proprietaire;

    public Date date_expiration;

    public int pass_carte;
    public float solde;
    public String banque;
    public String type;	
    public int id_u;
    
    

    public CarteBancaire(int id_carte, int num_carte, Utilisateur proprietaire, Date date_expiration, int pass_carte, float solde, String banque, String type, int id_u) {
        this.id_carte = id_carte;
        this.num_carte = num_carte;
        this.proprietaire = proprietaire;
        this.date_expiration = date_expiration;
        this.pass_carte = pass_carte;
        this.solde = solde;
        this.banque = banque;
        this.type = type;
        this.id_u = id_u;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }
    

    public CarteBancaire(int id_carte, int num_carte, Utilisateur proprietaire, Date date_expiration, int pass_carte, float solde, String banque, String type) {
        this.id_carte = id_carte;
        this.num_carte = num_carte;
        this.proprietaire = proprietaire;
        this.date_expiration = date_expiration;
        this.pass_carte = pass_carte;
        this.solde = solde;
        this.banque = banque;
        this.type = type;
    }

    public CarteBancaire(int num_carte , int id_u, Date date_expiration, int pass_carte, float solde, String banque, String type) {
        this.num_carte = num_carte;
        this.id_u = id_u;
        this.date_expiration = date_expiration;
        this.pass_carte = pass_carte;
        this.solde = solde;
        this.banque = banque;
        this.type = type;
        
    }

    public CarteBancaire(int num_carte, Utilisateur proprietaire, Date date_expiration, int pass_carte, float solde, String banque, String type) {
        this.num_carte = num_carte;
        this.proprietaire = proprietaire;
        this.date_expiration = date_expiration;
        this.pass_carte = pass_carte;
        this.solde = solde;
        this.banque = banque;
        this.type = type;
    }

    public CarteBancaire() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_carte() {
        return id_carte;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public int getNum_carte() {
        return num_carte;
    }

    public void setNum_carte(int num_carte) {
        this.num_carte = num_carte;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public int getPass_carte() {
        return pass_carte;
    }

    public void setPass_carte(int pass_carte) {
        this.pass_carte = pass_carte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarteBancaire{" + "id_carte=" + id_carte + ", num_carte=" + num_carte + ", proprietaire=" + proprietaire + ", date_expiration=" + date_expiration + ", pass_carte=" + pass_carte + ", solde=" + solde + ", banque=" + banque + ", type=" + type + '}';
    }
    
}
