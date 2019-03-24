package com.thalesdeluca.salesapi.Dto;

public class CreateSellerDto {
    private String name;

    public CreateSellerDto() {}

    public CreateSellerDto(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
