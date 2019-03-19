package com.thalesdeluca.salesapi.Dao;

import com.thalesdeluca.salesapi.Entity.Seller;
import org.springframework.data.repository.CrudRepository;

public interface ISellerDao extends CrudRepository<Seller, Integer> {}
