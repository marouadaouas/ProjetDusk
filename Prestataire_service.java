/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Kais
 */
public class Prestataire_service {
    private int id_prest;
    private String nom_prest;
    private String prenom_prest;
    private int age_prest;
    private long num_tel_prest;
    private int	adresse_prest;
    private String email_prest;
    private String login_prest;
    private String mdp_prest;
    private String enligne_prest;
    private String etat_prest;
    private String fonction;
    private String specialite;

    public Prestataire_service(int id_prest, String nom_prest, String prenom_prest, int age_prest, long num_tel_prest, int adresse_prest, String email_prest, String login_prest, String mdp_prest, String enligne_prest, String etat_prest, String fonction, String specialite) {
        this.id_prest = id_prest;
        this.nom_prest = nom_prest;
        this.prenom_prest = prenom_prest;
        this.age_prest = age_prest;
        this.num_tel_prest = num_tel_prest;
        this.adresse_prest = adresse_prest;
        this.email_prest = email_prest;
        this.login_prest = login_prest;
        this.mdp_prest = mdp_prest;
        this.enligne_prest = enligne_prest;
        this.etat_prest = etat_prest;
        this.fonction = fonction;
        this.specialite = specialite;
    }

    public Prestataire_service(String nom_prest, String prenom_prest, int age_prest, long num_tel_prest, int adresse_prest, String email_prest, String login_prest, String mdp_prest, String enligne_prest, String etat_prest, String fonction, String specialite) {
        this.nom_prest = nom_prest;
        this.prenom_prest = prenom_prest;
        this.age_prest = age_prest;
        this.num_tel_prest = num_tel_prest;
        this.adresse_prest = adresse_prest;
        this.email_prest = email_prest;
        this.login_prest = login_prest;
        this.mdp_prest = mdp_prest;
        this.enligne_prest = enligne_prest;
        this.etat_prest = etat_prest;
        this.fonction = fonction;
        this.specialite = specialite;
    }

    public Prestataire_service() {
    }

    public int getId_prest() {
        return id_prest;
    }

    public void setId_prest(int id_prest) {
        this.id_prest = id_prest;
    }

    public String getNom_prest() {
        return nom_prest;
    }

    public void setNom_prest(String nom_prest) {
        this.nom_prest = nom_prest;
    }

    public String getPrenom_prest() {
        return prenom_prest;
    }

    public void setPrenom_prest(String prenom_prest) {
        this.prenom_prest = prenom_prest;
    }

    public int getAge_prest() {
        return age_prest;
    }

    public void setAge_prest(int age_prest) {
        this.age_prest = age_prest;
    }

    public long getNum_tel_prest() {
        return num_tel_prest;
    }

    public void setNum_tel_prest(long num_tel_prest) {
        this.num_tel_prest = num_tel_prest;
    }

    public int getAdresse_prest() {
        return adresse_prest;
    }

    public void setAdresse_prest(int adresse_prest) {
        this.adresse_prest = adresse_prest;
    }

    public String getEmail_prest() {
        return email_prest;
    }

    public void setEmail_prest(String email_prest) {
        this.email_prest = email_prest;
    }

    public String getLogin_prest() {
        return login_prest;
    }

    public void setLogin_prest(String login_prest) {
        this.login_prest = login_prest;
    }

    public String getMdp_prest() {
        return mdp_prest;
    }

    public void setMdp_prest(String mdp_prest) {
        this.mdp_prest = mdp_prest;
    }

    public String getEnligne_prest() {
        return enligne_prest;
    }

    public void setEnligne_prest(String enligne_prest) {
        this.enligne_prest = enligne_prest;
    }

    public String getEtat_prest() {
        return etat_prest;
    }

    public void setEtat_prest(String etat_prest) {
        this.etat_prest = etat_prest;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_prest;
        hash = 29 * hash + Objects.hashCode(this.nom_prest);
        hash = 29 * hash + Objects.hashCode(this.prenom_prest);
        hash = 29 * hash + this.age_prest;
        hash = 29 * hash + (int) (this.num_tel_prest ^ (this.num_tel_prest >>> 32));
        hash = 29 * hash + this.adresse_prest;
        hash = 29 * hash + Objects.hashCode(this.email_prest);
        hash = 29 * hash + Objects.hashCode(this.login_prest);
        hash = 29 * hash + Objects.hashCode(this.mdp_prest);
        hash = 29 * hash + Objects.hashCode(this.enligne_prest);
        hash = 29 * hash + Objects.hashCode(this.etat_prest);
        hash = 29 * hash + Objects.hashCode(this.fonction);
        hash = 29 * hash + Objects.hashCode(this.specialite);
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
        final Prestataire_service other = (Prestataire_service) obj;
        if (this.id_prest != other.id_prest) {
            return false;
        }
        if (this.age_prest != other.age_prest) {
            return false;
        }
        if (this.num_tel_prest != other.num_tel_prest) {
            return false;
        }
        if (this.adresse_prest != other.adresse_prest) {
            return false;
        }
        if (!Objects.equals(this.nom_prest, other.nom_prest)) {
            return false;
        }
        if (!Objects.equals(this.prenom_prest, other.prenom_prest)) {
            return false;
        }
        if (!Objects.equals(this.email_prest, other.email_prest)) {
            return false;
        }
        if (!Objects.equals(this.login_prest, other.login_prest)) {
            return false;
        }
        if (!Objects.equals(this.mdp_prest, other.mdp_prest)) {
            return false;
        }
        if (!Objects.equals(this.enligne_prest, other.enligne_prest)) {
            return false;
        }
        if (!Objects.equals(this.etat_prest, other.etat_prest)) {
            return false;
        }
        if (!Objects.equals(this.fonction, other.fonction)) {
            return false;
        }
        if (!Objects.equals(this.specialite, other.specialite)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prestataire_service{" + "id_prest=" + id_prest + ", nom_prest=" + nom_prest + ", prenom_prest=" + prenom_prest + ", age_prest=" + age_prest + ", num_tel_prest=" + num_tel_prest + ", adresse_prest=" + adresse_prest + ", email_prest=" + email_prest + ", login_prest=" + login_prest + ", mdp_prest=" + mdp_prest + ", enligne_prest=" + enligne_prest + ", etat_prest=" + etat_prest + ", fonction=" + fonction + ", specialite=" + specialite + '}';
    }
    
    
    
}
