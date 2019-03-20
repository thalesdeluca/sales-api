package com.thalesdeluca.salesapi.Dto;

public class DailyAvgDto {
    private String name;
    private Long totalSold;
    private Float avgDaily;

    public DailyAvgDto() {}

    public DailyAvgDto(String name, Long totalSold) {
        setName(name);
        setTotalSold(totalSold);
    }

    public DailyAvgDto(String name, Long totalSold, Float avgDaily) {
        setName(name);
        setTotalSold(totalSold);
        setAvgDaily(avgDaily);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Long totalSold) {
        this.totalSold = totalSold;
    }

    public Float getAvgDaily() {
        return avgDaily;
    }

    public void setAvgDaily(Float avgDaily) {
        this.avgDaily = avgDaily;
    }
}
