package dao;

import entities.Auteur;

public class AuteurDao extends GenericDao<Auteur, Integer>{
    public AuteurDao(){
        this.classeEntite = Auteur.class;
    }
}
