package sn.gs.demo.service;

import sn.gs.demo.entities.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> getProduits();

    void addProduit(Produit produit);

    void updateProduit(Produit produit);

    void deleteProduit(Long id);

}
