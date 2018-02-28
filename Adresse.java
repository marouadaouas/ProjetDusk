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
public class Adresse {
    private int id_adresses;
    private String titre;
    private String ville;
    private String rue;
    private int code_postal;

    public Adresse(int id_adresses, String titre, String ville, String rue, int code_postal) {
        this.id_adresses = id_adresses;
        this.titre = titre;
        this.ville = ville;
        this.rue = rue;
        this.code_postal = code_postal;
    }

    
    
    public Adresse( String titre, String ville, String rue, int code_postal) {
        this.titre = titre;
        this.ville = ville;
        this.rue = rue;
        this.code_postal = code_postal;
    }

    public Adresse() {
    }

    public int getId_adresses() {
        return id_adresses;
    }

    public void setId_adresses(int id_adresses) {
        this.id_adresses = id_adresses;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    @Override
    public String toString() {
        return "adresse{" + "id_adresse=" + id_adresses + ", titre=" + titre + ", ville=" + ville + ", rue=" + rue + ", code_postal=" + code_postal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_adresses;
        hash = 29 * hash + Objects.hashCode(this.titre);
        hash = 29 * hash + Objects.hashCode(this.ville);
        hash = 29 * hash + Objects.hashCode(this.rue);
        hash = 29 * hash + this.code_postal;
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
        final Adresse other = (Adresse) obj;
        if (this.id_adresses != other.id_adresses) {
            return false;
        }
        if (this.code_postal != other.code_postal) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        if (!Objects.equals(this.ville, other.ville)) {
            return false;
        }
        if (!Objects.equals(this.rue, other.rue)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
