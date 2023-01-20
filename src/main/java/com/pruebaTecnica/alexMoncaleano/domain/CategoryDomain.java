package com.pruebaTecnica.alexMoncaleano.domain;

import org.springframework.stereotype.Component;

@Component
public class CategoryDomain {

    private Integer cid;
    private String title;

    public CategoryDomain(Integer cid, String title) {
        this.cid = cid;
        this.title = title;
    }

    public CategoryDomain() {

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
