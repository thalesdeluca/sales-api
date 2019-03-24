package com.thalesdeluca.salesapi.Repository;

import com.thalesdeluca.salesapi.Dto.DailyAvgDto;
import com.thalesdeluca.salesapi.Entity.Sale;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer> {}
