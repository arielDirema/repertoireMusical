package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auteur")
public class Auteur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auteur")
    private Integer id;

    @Column(name = "nom_auteur", length = 30, nullable = false)
    private String nom;

    //Constructors
    public Auteur(){}
    public Auteur(String nom){
        this.nom = nom;
    }

    //Getters & Setters
    public Integer getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auteur other = (Auteur) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Auteur [id=" + id + ", nom=" + nom + "]";
    }

}
