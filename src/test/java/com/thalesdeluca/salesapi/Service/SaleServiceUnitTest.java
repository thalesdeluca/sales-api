package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Entity.Sale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaleServiceUnitTest {

    @Autowired
    private SaleService saleService;

    @Autowired
    private RestTemplate template;

    @Test
    public void testGetAllSales() throws IOException {

    }
}
