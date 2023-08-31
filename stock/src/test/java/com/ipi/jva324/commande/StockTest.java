package com.ipi.jva324.commande;

import com.ipi.jva324.StockApplication;
import com.ipi.jva324.stock.model.ProduitEnStock;
import com.ipi.jva324.stock.repository.ProduitEnStockRepository;
import com.ipi.jva324.stock.service.ProduitService;
import com.ipi.jva324.stock.service.StockInvalideException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class) // Junit 4 : @RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(StockApplication.class)
public class StockTest {

    /** TODO rm, pas utile ici */
    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private ProduitEnStockRepository produitEnStockRepository;

    /** aide pour les tests */
    @Autowired
    private ProduitService produitService;

    @BeforeEach
    void setUp() {

    }

    /**
     * New section below to tests only stocks
     */
    @Test
    public void testProduitShouldInsert() throws StockInvalideException{
        ProduitEnStock p = new ProduitEnStock("test","ceci est une description",25l);
        produitService.createProduit(p);

        List<ProduitEnStock> productFromBase = produitService.getProduits();

        Assertions.assertTrue(productFromBase.contains(p));
    }

}
