package com.thalesdeluca.salesapi.Controller;

import com.thalesdeluca.salesapi.Dto.CreateSaleDto;
import com.thalesdeluca.salesapi.Entity.Sale;
import com.thalesdeluca.salesapi.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public Sale createSale(@RequestBody CreateSaleDto saleDto) {
        return saleService.createSale(saleDto.getValue(), saleDto.getSellerId());
    }

    @GetMapping
    public Collection<Sale> getAllSales() {
        return saleService.getAllSales();
    }
}
