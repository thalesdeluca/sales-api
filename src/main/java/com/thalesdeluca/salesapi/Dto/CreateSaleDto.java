package com.thalesdeluca.salesapi.Dto;

public class CreateSaleDto {
    private float value;
    private int sellerId;

    public CreateSaleDto() {}

    public CreateSaleDto(float value, int sellerId) {
        this.value = value;
        this.sellerId = sellerId;
    }

    public float getValue() {
        return value;
    }
    public int getSellerId(){
        return sellerId;
    }
}
