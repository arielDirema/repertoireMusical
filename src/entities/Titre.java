package entities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "titre")
public class Titre {
    @Id
    @Column(name = "id_titre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String libelle;

    @Column
    private String description;

    @Column(columnDefinition = "interval", nullable = false)
    @Convert(converter = DurationAttributeConverter.class)
    private Duration duree;

    @ManyToOne
    @JoinColumn(name = "artiste_id")
    private Auteur artiste;

    @ManyToMany
    @JoinTable(
        name = "titre_categorie",
        joinColumns = @JoinColumn(name = "titre_id"),
        inverseJoinColumns = @JoinColumn(name = "categorie_id")
    )
    private List<Categorie> categories;

    //Constructors
    public Titre(){}
    public Titre(String libelle, String description, Duration duree){
        this.libelle = libelle;
        this.description = description;
        this.duree = duree;
        artiste = new Auteur();
        categories = new ArrayList<>();
    }

    //Getters and setters
    public Integer getId(){
        return id;
    }
    public String getLibelle(){
        return libelle;
    }
    public String getDescription(){
        return description;
    }
    public String getDuree(){
        return duree.toString();
    }
    public Auteur getArtiste() {
        return artiste;
    }
    public List<Categorie> getCategories() {
        return categories;
    }
    
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDuree(Duration duree){
        this.duree = duree;
    }
    public void setArtiste(Auteur artiste) {
        this.artiste = artiste;
    }

    public void addCategorie(Categorie category){
        categories.add(category);
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
        Titre other = (Titre) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Titre [id=" + id + ", libelle=" + libelle + ", description=" + description + ", duree=" + duree.toString()
                + "]";
    }
}
