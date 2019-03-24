package com.thalesdeluca.salesapi.Service;
import com.thalesdeluca.salesapi.Dao.SaleDao;
import com.thalesdeluca.salesapi.Dao.SellerDao;
import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.assertj.core.api.LocalDateAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static com.thalesdeluca.salesapi.Util.SalesApiUtils.dateToLocalDate;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceUnitTest {

    @MockBean
    private SellerDao sellerDao;

    @MockBean
    private SaleDao saleDao;

    @InjectMocks
    private SellerService sellerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createSeller() {
        Seller seller = new Seller(123456, "Teste");
        Integer id = seller.getSellerId();

        given(sellerDao.checkId(any(Integer.class))).willReturn(false);
        given(sellerDao.createSeller(any(Seller.class))).willReturn(seller);

        seller = sellerService.createSeller("Teste");

        assertNotNull(seller);
        assertEquals("Teste", seller.getSellerName());
        assertEquals(123456, seller.getSellerId());
    }


    @Test
    public void getDailyAvg() {
        DailyAvgDto avg = new DailyAvgDto("Teste", 100L, 2.5f);
        Collection<DailyAvgDto> avgList = Collections.singletonList(avg);

        given(saleDao.getDailyAvg(any(LocalDate.class), any(LocalDate.class))).willReturn(avgList);

        Collection<DailyAvgDto> response = sellerService.getDailyAvg(1548036000000L, 1553278790198L);

        assertNotNull(response);
        assertEquals(avgList, response);
    }

    @Test
    public void getAllSellers() {
        Collection<Seller> sellerList = Collections
                .singletonList(new Seller(123456, "Teste"));

        given(sellerDao.getAllSellers()).willReturn(sellerList);

        Collection<Seller> result = sellerService.getAllSellers();

        assertNotNull(result);
        assertEquals(sellerList, result);
    }
}
