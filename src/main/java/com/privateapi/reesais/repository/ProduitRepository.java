package com.privateapi.reesais.repository;

import com.privateapi.reesais.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository <Produit, Long> {
}
