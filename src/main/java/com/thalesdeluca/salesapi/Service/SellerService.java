package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Dao.SaleDao;
import com.thalesdeluca.salesapi.Dao.SellerDao;
import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

@Service
public class SellerService {

    @Autowired
    private SellerDao sellerDao;

    @Autowired
    private SaleDao saleDao;

    public Seller createSeller(String name) {
        int id;

        do{
            Random rand = new Random();
            id = (rand.nextInt((999999 - 100000) + 1) + 100000);
        } while(sellerDao.checkId(id));

        return sellerDao.createSeller(new Seller(id, name));
    }

    public Collection<Seller> getAllSellers() {
        return sellerDao.getAllSellers();
    }

    public Collection<DailyAvgDto> getDailyAvg(Date begin, Date end) {

        Collection<DailyAvgDto> list = saleDao.getAvgDaily(begin, end);

        LocalDate beginDate = dateToLocalDate(begin);
        LocalDate endDate = dateToLocalDate(end);

        long diffInDays = ChronoUnit.DAYS.between(beginDate, endDate) + 1;
        System.out.println(diffInDays);

        list.forEach(entry -> {
            entry.setAvgDaily((float) entry.getTotalSold() / (diffInDays));
        });

        return list;
    }

    private LocalDate dateToLocalDate(Date date){
        return Instant.ofEpochMilli(date.getTime())
                      .atZone(ZoneId.systemDefault())
                      .toLocalDate();
    }


}
