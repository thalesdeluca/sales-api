package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class SellerDao {

    @Autowired
    private SellerRepository sellerRepository;

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

    public Collection<DailyAvgDto> getDailyAvg(LocalDate begin, LocalDate end) {
        return sellerRepository.getSaleRange(begin, end);
    }


}
