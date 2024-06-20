package service;

import dao.TitreDao;
import entities.Titre;

public class TitreService extends GenericSercive<Titre, Integer>{
    public TitreService(){
        this.dao = new TitreDao();
    }
}
