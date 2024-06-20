package service;

import dao.CategotieDao;
import entities.Categorie;

public class CategorieService extends GenericSercive<Categorie, Integer>{
    public CategorieService(){
        this.dao = new CategotieDao();
    }
}
