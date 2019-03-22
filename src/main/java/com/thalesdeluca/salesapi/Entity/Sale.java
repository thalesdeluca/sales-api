package com.thalesdeluca.salesapi.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.*;
import java.util.Locale;

@Component
@Entity
@Table(name = "sale")
public class Sale {

    @Id private int id;
    @NotNull private float value;
    @ManyToOne private Seller seller;
    private long dateLong;
    @NotNull private LocalDate saleDate;

    public Sale() { }

    public Sale(int id, long date, float value) {
        setId(id);
        setDate(date);
        setValue(value);
        setDateLong(date);
    }

    public Sale(int id, long date, float value, Seller seller) {
        setId(id);
        setDate(date);
        setValue(value);
        setSeller(seller);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return saleDate;
    }

    public void setDate(long date) {
        this.saleDate = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
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

    private void setDateLong(long date) {
        this.dateLong = date;
    }

    public long getDateLong() {
        return dateLong;
    }
}
