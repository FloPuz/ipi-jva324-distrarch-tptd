package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Qualifier("commandeProduitServiceLocalImpl")
public class CommandeProduitServiceLocalImpl implements CommandeProduitService{

    @Autowired
    private ProduitService produitService;

    @Override
    public ProduitEnStock getProduit(Long id) {
        return produitService.getProduit(id);
    }

}
