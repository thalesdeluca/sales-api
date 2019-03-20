package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ISaleDao extends CrudRepository<Sale, Integer> {
    @Query("SELECT new com.thalesdeluca.salesapi.Dto.DailyAvgDto(se.sellerName, COUNT(sa.id)) " +

            "FROM Sale sa INNER JOIN Seller se " +
            "     ON sa.seller.sellerId = se.sellerId " +

            "WHERE sa.saleDate BETWEEN ?1 AND ?2 " +

            "GROUP BY se.sellerId, se.sellerName")
    public List<DailyAvgDto> getSaleRange(Date begin, Date end);
}
