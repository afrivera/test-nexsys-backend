package com.afrivera.pruebanexsys.dto.request;

import java.util.ArrayList;
import java.util.List;

public class ProductRequestCloudDto {

    private String title;
    private int price;
    private Long categoryId;
    private String description;
    private List<String> images;

    public ProductRequestCloudDto() {
        images = new ArrayList<>();
    }

    public void addImage(String image){
        images.add(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
