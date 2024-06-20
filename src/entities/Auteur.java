package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "auteur")
public class Auteur extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auteur")
    private Integer id;

    @Column(name = "nom_auteur", length = 30, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Titre> titres;

    //Constructors
    public Auteur(){}
    public Auteur(String nom){
        this.nom = nom;
        titres = new ArrayList<>();
    }

    //Getters & Setters
    public Integer getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public List<Titre> getTitres() {
        return titres;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void addTitre(Titre titre){
        titres.add(titre);
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
