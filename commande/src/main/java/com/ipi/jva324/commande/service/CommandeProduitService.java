package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import org.springframework.stereotype.Component;

import java.util.List;

public interface CommandeProduitService {

    public ProduitEnStock getProduit(Long id);
}
