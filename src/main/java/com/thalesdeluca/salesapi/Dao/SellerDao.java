package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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

    public boolean checkId(Integer id) {
        Iterable<Seller> sellerList = sellerRepository.findAll();

        for(Seller seller : sellerList) {
            if(seller.getSellerId() == id) {
                return true;
            }
        }

        return false;
    }


}
