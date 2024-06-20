package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private Integer id;

    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "description")
    private String description;

    //Constructors
    public Categorie(){}
    public Categorie(String libelle, String description){
        this.libelle = libelle;
        this.description = description;
    }

    //Getters & Setters
    public Integer getId(){
        return id;
    }
    public String getLibelle(){
        return libelle;
    }
    public String getDescription(){
        return description;
    }

    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public void setDescription(String description){
        this.description = description;
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
        Categorie other = (Categorie) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Categorie [id=" + id + ", libelle=" + libelle + ", description=" + description + "]";
    }
}
