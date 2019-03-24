package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Dao.SaleDao;
import com.thalesdeluca.salesapi.Entity.Sale;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceUnitTest {

    @InjectMocks
    private SaleService saleService;

    @Mock
    private SaleDao saleDao;

    @Test
    public void createSale() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));

        given(saleDao.createSale(any(Sale.class))).willReturn(sale);
        given(saleDao.checkId(any(Integer.class))).willReturn(false);

        Sale result = saleService.createSale(50.5f, 123456);
        assertNotNull(result);
        assertEquals(sale, result);
    }

    @Test
    public void getAllSales() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));
        Collection<Sale> saleList = Collections.singletonList(sale);

        given(saleDao.getAllSales()).willReturn(saleList);

        Collection<Sale> response = saleService.getAllSales();

        assertNotNull(response);
        assertEquals(saleList, response);
    }
}
