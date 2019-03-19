package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Entity.Sale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleDao extends CrudRepository<Sale, Integer> {}
