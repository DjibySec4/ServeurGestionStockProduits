package sn.gs.demo.service;

import org.springframework.stereotype.Service;
import sn.gs.demo.entities.Produit;

import java.util.ArrayList;
import java.util.List;

//ce @Service c pour que cette classe soit injectable dans les controller afin d'appeler ses methodes.
@Service
public class ProduitMockServiceImpl implements ICrudService<Produit, Long> {

    private List<Produit> produits;

    public  ProduitMockServiceImpl(){
        produits = new ArrayList<Produit>();
        produits.add(new Produit("Livre", 50, 20));
        produits.add(new Produit("Cahier", 200, 5.25f));
        produits.add(new Produit("Stylo", 500, 2.10f));
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public void add(Produit produit) {
        this.produits.add(produit);
    }

    @Override
    public void update(Produit produit) {
        //On remplace le produit par un autre
        this.produits.add(produit);
        this.produits.remove(produit);
    }

   /* @Override
    public void deleteProduit(String ref) {
        Produit produit = new Produit();
        produit.setRef(ref);
        this.produits.remove(produit);
    }*/

    @Override
    public void delete(Long id) {
        Produit produit = new Produit();
        produit.setId(id);
        this.produits.remove(produit);
    }
}
