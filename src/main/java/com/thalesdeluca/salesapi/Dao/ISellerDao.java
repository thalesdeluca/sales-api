package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISellerDao extends CrudRepository<Seller, Integer> {}
