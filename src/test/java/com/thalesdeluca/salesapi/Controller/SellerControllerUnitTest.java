package com.thalesdeluca.salesapi.Controller;


import com.google.gson.Gson;
import com.thalesdeluca.salesapi.Dto.CreateSellerDto;
import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Service.SellerService;
import com.thalesdeluca.salesapi.Entity.Sale;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.*;
import java.util.Collection;
import java.util.Collections;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SellerController.class)
public class SellerControllerUnitTest {

    @MockBean
    private SellerService sellerService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void createSeller() throws Exception {
        CreateSellerDto dto = new CreateSellerDto("Teste");

        Seller seller = new Seller(123456, "Teste");
        given(sellerService.createSeller("Teste")).willReturn(seller);

        mvc.perform(post("/sellers")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new Gson().toJson(dto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(new Gson().toJson(seller)));
    }

    @Test
    public void getAllSellers() throws Exception{
        Seller seller = new Seller(123456, "Teste");
        Collection<Seller> sellerList = Collections.singletonList(seller);

        given(sellerService.getAllSellers()).willReturn(sellerList);

        mvc.perform(get("/sellers"))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(sellerList)));
    }

    @Test
    public void getDailyAvg() throws Exception {
        String begin = "1548036000000";
        String end = "1553278790198";

        DailyAvgDto avg = new DailyAvgDto("Teste", 100L, 2.5f);

        Collection<DailyAvgDto> avgList = Collections.singletonList(avg);

        given(sellerService.getDailyAvg(1548036000000L, 1553278790198L)).willReturn(avgList);

        mvc.perform(get("/sellers/avg")
                .param("begin", begin)
                .param("end", end))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(avgList)));
    }
}
