/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Time;

/**
 *
 * @author Esprit1
 */
public class Parapharmacie {
    
    public int id_para;
    public String nom_para;
    public int adresse_para;
    public int num_tel_para;
    public String email_para;
    public Time horaire_ouverture_para;
    public Time horaire_fermeture_para;
    public int id_resp_para;

    public Parapharmacie(int id_para, String nom_para, int adresse_para, int num_tel_para, String email_para, Time horaire_ouverture_para, Time horaire_fermeture_para, int id_resp_para) {
        this.id_para = id_para;
        this.nom_para = nom_para;
        this.adresse_para = adresse_para;
        this.num_tel_para = num_tel_para;
        this.email_para = email_para;
        this.horaire_ouverture_para = horaire_ouverture_para;
        this.horaire_fermeture_para = horaire_fermeture_para;
        this.id_resp_para = id_resp_para;
    }
   

    public Parapharmacie( String nom_para, int adresse_para, int num_tel_para, String email_para, Time horaire_ouverture_para, Time horaire_fermeture_para, int id_resp_para) {
        
        this.nom_para = nom_para;
        this.adresse_para = adresse_para;
        this.num_tel_para = num_tel_para;
        this.email_para = email_para;
        this.horaire_ouverture_para = horaire_ouverture_para;
        this.horaire_fermeture_para = horaire_fermeture_para;
        this.id_resp_para = id_resp_para;
    }

    public Parapharmacie() {
      
    }

    public int getId_para() {
        return id_para;
    }

    public void setId_para(int id_para) {
        this.id_para = id_para;
    }

    public String getNom_para() {
        return nom_para;
    }

    public void setNom_para(String nom_para) {
        this.nom_para = nom_para;
    }

    public int getAdresse_para() {
        return adresse_para;
    }

    public void setAdresse_para(int adresse_para) {
        this.adresse_para = adresse_para;
    }

    public int getNum_tel_para() {
        return num_tel_para;
    }

    public void setNum_tel_para(int num_tel_para) {
        this.num_tel_para = num_tel_para;
    }

    public String getEmail_para() {
        return email_para;
    }

    public void setEmail_para(String email_para) {
        this.email_para = email_para;
    }

    public Time getHoraire_ouverture_para() {
        return horaire_ouverture_para;
    }

    public void setHoraire_ouverture_para(Time horaire_ouverture_para) {
        this.horaire_ouverture_para = horaire_ouverture_para;
    }

    public Time getHoraire_fermeture_para() {
        return horaire_fermeture_para;
    }

    public void setHoraire_fermeture_para(Time horaire_fermeture_para) {
        this.horaire_fermeture_para = horaire_fermeture_para;
    }

    public int getId_resp_para() {
        return id_resp_para;
    }

    public void setId_resp_para(int id_resp_para) {
        this.id_resp_para = id_resp_para;
    }

    @Override
    public String toString() {
        return "Parapharmacie{" + "id_para=" + id_para + ", nom_para=" + nom_para + ", adresse_para=" + adresse_para + ", num_tel_para=" + num_tel_para + ", email_para=" + email_para + ", horaire_ouverture_para=" + horaire_ouverture_para + ", horaire_fermeture_para=" + horaire_fermeture_para + ", id_resp_para=" + id_resp_para + '}';
    }
    
    
}
