package com.afrivera.pruebanexsys.dto.request;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProductRequestInternalDto {

    @NotEmpty
    private String name;

    @NotNull
    @Positive
    private Integer priceFinal;

    @NotEmpty
    private String description;
    private Long categoryId;

    @NotEmpty
    @URL
    private String imageUrl;

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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
