package sn.gs.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sn.gs.demo.dao.ProduitRepository;
import sn.gs.demo.entities.Produit;

import java.util.List;

//Com on a 2 services qui implemente la meme interface(ProduitMockService et ProduitService), ca p poser probleme ds l
//controller. C prkw on a ajouter @Primary pr dire k ce service sera prooritaire si on appelle une meth du repository dans le controller
@Service
@Primary
public class ProduitService implements ICrudService<Produit, Long> {

    @Autowired
    private ProduitRepository produitRepositiry;

    @Override
    public List<Produit> getAll() {
        return this.produitRepositiry.findAll();
    }

    @Override
    public void add(Produit produit) {
        produitRepositiry.save(produit);
    }

    @Override
    public void update(Produit produit) {
        produitRepositiry.save(produit);
    }

    @Override
    public void delete(Long id) {
        Produit produit = new Produit();
        produit.setId(id);
        produitRepositiry.delete(produit);

    }
}
