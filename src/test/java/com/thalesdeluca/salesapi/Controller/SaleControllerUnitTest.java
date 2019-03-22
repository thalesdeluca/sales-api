package com.thalesdeluca.salesapi.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thalesdeluca.salesapi.Dto.CreateSaleDto;
import com.thalesdeluca.salesapi.Entity.Sale;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;


@RunWith(SpringRunner.class)
@WebMvcTest(SaleController.class)
public class SaleControllerUnitTest {

    private MockMvc mvc;

    @MockBean
    private SaleController saleController;

    @Before
    public void init() {
        mvc = MockMvcBuilders.standaloneSetup(saleController).build();
    }

    @Test
    public void getAllSales() throws Exception {

        Sale sale = new Sale(153468, 1553228667949L, 50.50f, new Seller(123456, "Jesus"));
        List<Sale> allSales = Collections.singletonList(sale);

        given(saleController.getAllSales()).willReturn(allSales);
        mvc.perform(get("/sales"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id':153468,'value':50.5,'seller':{'sellerId':123456,'sellerName':'Jesus'},'dateLong':1553228667949,'date':'2019-03-22'}]"));

    }

    @Test
    public void createSale() throws Exception {

        CreateSaleDto dto = new CreateSaleDto(50.5f, 123456);
        Sale sale = new Sale(153468, 1553228667949L, 50.50f, new Seller(123456, "Jesus"));


        given(saleController.createSale(dto)).willReturn(sale);
        mvc.perform(post("/sales")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(toJson(dto)))
                .andExpect(status().isCreated());

        when(saleController.createSale(dto)).thenReturn(sale);
    }

    //400 - Bad Request - Type Mismatch
    @Test
    public void createSaleMismatch() throws Exception {

        mvc.perform(post("/sales")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content("{'value':'50.5','sellerId':'123456'}"))
                .andExpect(status().isBadRequest());
    }

    private static String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
