package dao;

import entities.Titre;

public class TitreDao extends GenericDao<Titre, Integer>{
    public TitreDao() {
        this.classeEntite = Titre.class;
    }
}
