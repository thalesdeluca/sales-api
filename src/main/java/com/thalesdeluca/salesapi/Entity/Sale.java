package com.thalesdeluca.salesapi.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
@Entity
@Table(name = "sale")
public class Sale {

    @Id private int id;
    @NotNull private Date saleDate;
    @NotNull private float value;
    @ManyToOne private Seller seller;
    private long dateLong;

    public Sale() { }

    public Sale(int id, Date date, float value) {
        setId(id);
        setDate(date);
        setValue(value);
        setDateLong(date);
    }

    public Sale(int id, Date date, float value, Seller seller) {
        setId(id);
        setDate(date);
        setValue(value);
        setSeller(seller);
        setDateLong(date);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return saleDate;
    }

    public void setDate(Date date) {
        this.saleDate = date;
        setDateLong(date);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    private void setDateLong(Date date) {
        this.dateLong = date.getTime();
    }

    public long getDateLong() {
        return dateLong;
    }
}
