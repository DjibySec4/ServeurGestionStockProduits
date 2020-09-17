package sn.gs.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.gs.demo.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
