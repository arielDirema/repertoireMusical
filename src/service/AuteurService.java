package service;

import dao.AuteurDao;
import entities.Auteur;

public class AuteurService extends GenericSercive<Auteur, Integer>{
    public AuteurService(){
        this.dao = new AuteurDao();
    }
}
