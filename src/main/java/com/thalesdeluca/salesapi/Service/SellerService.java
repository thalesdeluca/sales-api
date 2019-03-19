package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Dao.SellerDao;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Random;

@Service
public class SellerService {

    @Autowired
    private SellerDao sellerDao;

    public Seller createSeller(String name) {
        int id;

        do{
            Random rand = new Random();
            id = (rand.nextInt((999999 - 1000) + 1) + 1000);
        } while(sellerDao.checkId(id));

        return sellerDao.createSeller(new Seller(id, name));
    }

    public Collection<Seller> getAllSellers() {
        return sellerDao.getAllSellers();
    }
}
