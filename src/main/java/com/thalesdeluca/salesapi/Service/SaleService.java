package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Dao.SaleDao;
import com.thalesdeluca.salesapi.Entity.Sale;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Service
public class SaleService {

    @Autowired
    private SaleDao saleDao;


    public Sale createSale(float value, int sellerId) {
        Integer id;

        do{
            Random rand = new Random();
            id = rand.nextInt((999999 - 1000) + 1) + 1000;
        } while(saleDao.checkId(id));


        return saleDao.createSale(new Sale(id, System.currentTimeMillis(), value, new Seller(sellerId)));
    }

    public Collection<Sale> getAllSales() {
        return saleDao.getAllSales();
    }

}
