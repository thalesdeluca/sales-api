package com.thalesdeluca.salesapi.Controller;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestParam String name){
        return sellerService.createSeller(name);
    }

    @GetMapping
    public Collection<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/avg")
    public Collection<DailyAvgDto> getDailyAvg(@RequestParam long begin, @RequestParam long end){
        return sellerService.getDailyAvg(new Date(begin), new Date(end));
    }

}
