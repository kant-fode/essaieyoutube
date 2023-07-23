package com.privateapi.reesais.Service;

import com.privateapi.reesais.modele.Produit;
import com.privateapi.reesais.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class ProduitServiceImplement implements ProduitService {
    private final ProduitRepository produitRepository;
    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id).map(p-> {
            p.setPrix(produit.getPrix());
            p.setNom(produit.getNom());
            p.setDescription(produit.getDescription());
            return produitRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("produit non trouver"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "produit suppreimer avec succès";
    }
}
