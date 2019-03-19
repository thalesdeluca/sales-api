package com.thalesdeluca.salesapi.Controller;

import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

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
}
