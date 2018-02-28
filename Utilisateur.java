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
public class Utilisateur {
    private int id_u;
    private String nom;
    private String prenom;
    private int age;
    private int adresse_u;
    private String email;
    private long num_tel;
    private String login;
    private String password;
    private String enligne;
    private String etat;

    public Utilisateur() {
    }
    
    

    public Utilisateur(int id_u, String nom, String prenom, int age, int adresse_u, String email, long num_tel, String login, String password, String enligne, String etat) {
        this.id_u = id_u;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse_u = adresse_u;
        this.email = email;
        this.num_tel = num_tel;
        this.login = login;
        this.password = password;
        this.enligne = enligne;
        this.etat = etat;
    }

    public Utilisateur(String nom, String prenom, int age, int adresse_u, String email, long num_tel, String login, String password, String enligne, String etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse_u = adresse_u;
        this.email = email;
        this.num_tel = num_tel;
        this.login = login;
        this.password = password;
        this.enligne = enligne;
        this.etat = etat;
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAdresse_u() {
        return adresse_u;
    }

    public void setAdresse_u(int adresse_u) {
        this.adresse_u = adresse_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(long num_tel) {
        this.num_tel = num_tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnligne() {
        return enligne;
    }

    public void setEnligne(String enligne) {
        this.enligne = enligne;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id_u;
        hash = 83 * hash + Objects.hashCode(this.nom);
        hash = 83 * hash + Objects.hashCode(this.prenom);
        hash = 83 * hash + this.age;
        hash = 83 * hash + this.adresse_u;
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + (int) (this.num_tel ^ (this.num_tel >>> 32));
        hash = 83 * hash + Objects.hashCode(this.login);
        hash = 83 * hash + Objects.hashCode(this.password);
        hash = 83 * hash + Objects.hashCode(this.enligne);
        hash = 83 * hash + Objects.hashCode(this.etat);
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.id_u != other.id_u) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (this.adresse_u != other.adresse_u) {
            return false;
        }
        if (this.num_tel != other.num_tel) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.enligne, other.enligne)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_u=" + id_u + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", adresse_u=" + adresse_u + ", email=" + email + ", num_tel=" + num_tel + ", login=" + login + ", password=" + password + ", enligne=" + enligne + ", etat=" + etat + '}';
    }
    
    
    
    
    
}
