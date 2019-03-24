package com.thalesdeluca.salesapi.Service;

import com.thalesdeluca.salesapi.Dao.SaleDao;
import com.thalesdeluca.salesapi.Dao.SellerDao;
import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Seller;
import com.thalesdeluca.salesapi.Entity.Sale;
import static com.thalesdeluca.salesapi.Util.SalesApiUtils.*;
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

    public Seller createSeller(String name){
        return sellerDao.createSeller(new Seller(generateId(), name));
    }

    public Collection<Seller> getAllSellers() {
        return sellerDao.getAllSellers();
    }

    public Collection<DailyAvgDto> getDailyAvg(long begin, long end) {
        LocalDate beginDate = dateToLocalDate(begin);
        LocalDate endDate = dateToLocalDate(end);

        Collection<DailyAvgDto> list = sellerDao.getDailyAvg(beginDate, endDate);

        long diffInDays = ChronoUnit.DAYS.between(beginDate, endDate) + 1;
        System.out.println(diffInDays);

        list.forEach(entry -> {
            entry.setAvgDaily((float) entry.getTotalSold() / (diffInDays));
        });

        return list;
    }

    private Integer generateId() {
        Integer id;
        do {
            Random rand = new Random();
            id = (rand.nextInt((999999 - 100000) + 1) + 100000);
        } while(sellerDao.checkId(id));
        return id;
    }

}
