package com.afrivera.pruebanexsys.dto.response;

public class CategoryGetAllDto {

    private Long cid;
    private  String title;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
