package dao;

import java.util.List;

import entities.BaseEntity;
import util.JpaTransactionUtil;

/**
 *
 * @author djim
 * @param <T>
 * @param <Key>
 */
public class GenericDao<T extends BaseEntity , Key extends Object> {

    protected Class<T> classeEntite;

    public void ajouter(T entite) {
        JpaTransactionUtil.executeUpdate(em -> {
            em.persist(entite);
        });
    }

    public T modifier(T entite) {
        return JpaTransactionUtil.executeQuery(em -> {
            return em.merge(entite);
        });
    }

    public T trouver(Key id) {
        return JpaTransactionUtil.executeQuery(em -> em.find(classeEntite, id));
    }

    public void supprimer(T entity){
        JpaTransactionUtil.executeUpdate(em -> em.remove(entity));
    }

    public void supprimer(Key id){
        T entity =  this.trouver(id);
        this.supprimer(entity);
    }

    public List<T> lister() {
        return JpaTransactionUtil.executeQuery(em -> {
            var query = em.createQuery("SELECT e FROM "
                            + classeEntite.getSimpleName()
                            + " e",
                    classeEntite);
            return query.getResultList();
        });
    }
}
