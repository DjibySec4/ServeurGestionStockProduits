package sn.gs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.gs.demo.entities.Produit;
import sn.gs.demo.service.IProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin
public class ProduitController {

    @Autowired
    private IProduitService produitService;

    @GetMapping
    public List<Produit> getProduits()
    {
        return this.produitService.getProduits();
    }

    @PostMapping
    public void addProduit(@RequestBody Produit produit)
    {
        this.produitService.addProduit(produit);
    }

    @PutMapping
    public void updateProduit(@RequestBody Produit produit)
    {
        this.produitService.updateProduit(produit);
    }

    @DeleteMapping("/{ref}")
    public void deleteProduit(@PathVariable String ref)
    {
        this.produitService.deleteProduit(ref);
    }
}
