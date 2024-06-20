package dao;

import entities.Categorie;

public class CategotieDao extends GenericDao<Categorie, Integer>{
    public CategotieDao (){
        this.classeEntite = Categorie.class;
    }
}
