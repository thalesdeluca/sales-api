package com.thalesdeluca.salesapi.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Component
@Entity
@Table(name = "seller")
public class Seller {

    @Id private int sellerId;
    private String sellerName;

    public Seller() {}

    public Seller(int id) {
        setSellerId(id);
    }

    public Seller(int id, String name){
        setSellerId(id);
        setSellerName(name);
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}
