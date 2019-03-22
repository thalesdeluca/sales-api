package com.thalesdeluca.salesapi.Controller;


import com.thalesdeluca.salesapi.Entity.Seller;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class SellerControllerUnitTest {

    @MockBean
    private SellerController sellerController;

    private MockMvc mvc;

    @Before
    public void init() {
        mvc = MockMvcBuilders.standaloneSetup(sellerController).build();
    }


    @Test
    public void createSeller() throws Exception {

    }

    @Test
    public void getAllSellers()  throws Exception{
        Seller seller = new Seller(123456, "Jesus");
        Collection<Seller> sellerList = Collections.singletonList(seller);

        given(sellerController.getAllSellers()).willReturn(sellerList);

        mvc.perform(get("/sellers"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'sellerId':123456,'sellerName':'Jesus'}]"));
    }

    @Test
    public void getDailyAvg()  throws Exception{
    }
}
