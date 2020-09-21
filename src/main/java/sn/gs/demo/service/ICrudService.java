package sn.gs.demo.service;

import java.util.List;

//Comme ici on a 2 service(ProduitService et UserService), on use la généricité en mettant par ex T au lieu de l'entite
//Produit ou User pr kil soit adapté a tous les entités

public interface ICrudService<T, ID> {

    List<T> getAll();

    void add(T entity);

    void update(T entity);

    void delete(ID id);

}
