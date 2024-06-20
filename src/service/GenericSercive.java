package service;

import java.util.List;

import dao.GenericDao;

/**
 *
 * @author djim
 * @param <T>
 * @param <Key>
 */
public class GenericSercive<T, Key extends Object> {

    protected  GenericDao<T, Key> dao;

    public void ajouter(T entite) {
        this.dao.ajouter(entite);
    }

    public T modifier(T entite) {
        return this.dao.modifier(entite);
    }

    public T trouver(Key id) {
        return this.dao.trouver(id);
    }

    public void supprimer(T entity){
        this.dao.supprimer(entity);
    }

    public void supprimer(Key id){
        this.dao.supprimer(id);
    }

    public List<T> lister() {
        return this.dao.lister();
    }
}

