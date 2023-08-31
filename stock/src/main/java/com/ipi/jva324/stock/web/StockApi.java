package com.ipi.jva324.stock.web;


import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/stocks")
public class StockApi {

    @Autowired
    private ProduitService produitService;

    @GetMapping("/produits/{id}")
    public ResponseEntity<ProduitEnStock> getProduitById(@PathVariable(value = "id") Long id) {
        ProduitEnStock p = produitService.getProduit(id);
        return ResponseEntity.ok(p);
    }

}
