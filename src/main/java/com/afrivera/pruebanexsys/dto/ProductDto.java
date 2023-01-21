package com.afrivera.pruebanexsys.dto;

public class ProductDto {

    private Long pid;
    private String name;
    private Integer priceFinal;
    private String description;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceFinal() {
        return priceFinal;
    }

    public void setPriceFinal(Integer priceFinal) {
        this.priceFinal = priceFinal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
