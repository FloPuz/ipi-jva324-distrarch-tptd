package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Qualifier("commandeProduitServiceRESTHALImpl")
public class CommandeProduitServiceRESTHALImpl implements CommandeProduitService{


    @Autowired
    private RestTemplate springDataRestTemplate;

    @Value("${commande.apiserver.url:http://localhost:8080/}")
    private String url;

    @Autowired
    private ProduitService produitService;

    @Override
    public ProduitEnStock getProduit(Long id) {
        ProduitEnStock p = springDataRestTemplate.getForObject(url+"api/api-rest/produitEnStocks/"+id, ProduitEnStock.class);
        return p;
    }

}
