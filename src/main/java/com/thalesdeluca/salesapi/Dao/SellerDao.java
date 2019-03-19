package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SellerDao {

    @Autowired
    private ISellerDao sellerRepository;

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Collection<Seller> getAllSellers() {
        ArrayList<Seller> sellerList = new ArrayList<>();
        Iterable<Seller> sellers = sellerRepository.findAll();

        for(Seller seller : sellers) {
            sellerList.add(seller);
        }

        return sellerList;
    }

    public boolean checkId(int id) {
        Iterable<Seller> sellerList = sellerRepository.findAll();

        for(Seller seller : sellerList) {
            if(seller.getSellerId() == id) {
                return true;
            }
        }

        return false;
    }

}
