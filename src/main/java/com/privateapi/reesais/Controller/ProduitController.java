package com.privateapi.reesais.Controller;

import com.privateapi.reesais.Service.ProduitService;
import com.privateapi.reesais.modele.Produit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor

public class ProduitController {
    private final ProduitService produitService;
    @PostMapping("/create")
    public Produit create (@RequestBody Produit produit){
        return produitService.creer(produit);
    }
    @GetMapping
    public List<Produit> read(){
        return produitService.lire();
    }
    @PutMapping("/update/{id}")
    public Produit update(@PathVariable Long id, @RequestBody Produit produit){
        return produitService.modifier(id, produit);
    }
    @DeleteMapping("/delete")
    public String delete(@PathVariable Long id){
        return produitService.supprimer(id);
    }
}
