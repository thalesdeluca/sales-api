package com.thalesdeluca.salesapi.Dao;

import com.google.gson.Gson;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Repository.SaleRepository;
import com.thalesdeluca.salesapi.Entity.Sale;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.junit.Assert.*;

public class SaleDaoUnitTest {

    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleDao saleDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createSale() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));

        given(saleRepository.save(sale)).willReturn(sale);

        Sale result = saleDao.createSale(sale);

        assertNotNull(result);
        assertEquals(sale, result);
    }

    @Test
    public void checkIdOk() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));
        Iterable<Sale> saleList = Collections.singletonList(sale);

        given(saleRepository.findAll()).willReturn(saleList);

        boolean result = saleDao.checkId(123456);

        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void checkIdExisting() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));
        Iterable<Sale> saleList = Collections.singletonList(sale);

        given(saleRepository.findAll()).willReturn(saleList);

        boolean result = saleDao.checkId(789456);

        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void getAllSales() {
        Sale sale = new Sale(789456, 1553278790198L, 50.5f, new Seller(123456, "Teste"));
        Iterable<Sale> saleList = Collections.singletonList(sale);

        given(saleRepository.findAll()).willReturn(saleList);

        Collection<Sale> result = saleDao.getAllSales();
        ArrayList<Sale> expected = new ArrayList<>();
        expected.add(sale);

        assertNotNull(result);
        assertEquals(expected, result);
    }
}