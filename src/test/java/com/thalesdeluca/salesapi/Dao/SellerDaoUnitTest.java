package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Sale;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Repository.SellerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.thalesdeluca.salesapi.Util.SalesApiUtils.dateToLocalDate;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class SellerDaoUnitTest {

    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private SellerDao sellerDao;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createSeller() {
        Seller seller = new Seller(123456, "Teste");

        given(sellerRepository.save(seller)).willReturn(seller);

        Seller result = sellerDao.createSeller(seller);

        assertNotNull(result);
        assertEquals(seller, result);
    }

    @Test
    public void getAllSellers() {
        Seller seller = new Seller(123456, "Teste");
        Iterable<Seller> sellerList = Collections.singletonList(seller);

        given(sellerRepository.findAll()).willReturn(sellerList);

        Collection<Seller> result = sellerDao.getAllSellers();
        ArrayList<Seller> expected = new ArrayList<>();
        expected.add(seller);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void checkIdOk() {
        Seller seller = new Seller(123456, "Teste");
        Iterable<Seller> sellerList = Collections.singletonList(seller);

        given(sellerRepository.findAll()).willReturn(sellerList);

        boolean result = sellerDao.checkId(789456);

        assertNotNull(result);
        assertFalse(result);
    }

    @Test
    public void checkIdExisting() {
        Seller seller = new Seller(123456, "Teste");
        Iterable<Seller> sellerList = Collections.singletonList(seller);

        given(sellerRepository.findAll()).willReturn(sellerList);

        boolean result = sellerDao.checkId(123456);

        assertNotNull(result);
        assertTrue(result);
    }

    @Test
    public void getDailyAvg() {
        LocalDate begin = dateToLocalDate(1548036000000L);
        LocalDate end = dateToLocalDate(1553278790198L);

        DailyAvgDto avg = new DailyAvgDto("Teste", 100L, 2.5f);
        List<DailyAvgDto> avgList = Collections.singletonList(avg);

        given(sellerRepository.getSaleRange(begin, end)).willReturn(avgList);

        Collection<DailyAvgDto> result = sellerDao.getDailyAvg(begin, end);
        Collection<DailyAvgDto> expected = avgList;

        assertNotNull(result);
        assertEquals(expected, result);

    }
}