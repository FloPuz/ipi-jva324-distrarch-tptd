package com.ipi.jva324.commande.service;

import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Qualifier("commandeProduitServiceRestImpl")
public class CommandeProduitServiceRestImpl implements CommandeProduitService{


    @Autowired
    private RestTemplate springDataRestTemplate;

    @Value("${stock.apiserver.url:http://localhost:8081/}")
    private String url;


    @Override
    public ProduitEnStock getProduit(Long id) {
        ResponseEntity<ProduitEnStock> p = springDataRestTemplate.getForObject(url+"api/api-rest/produitEnStocks/"+id, ResponseEntity.class);
        return p.getBody();
    }

}
