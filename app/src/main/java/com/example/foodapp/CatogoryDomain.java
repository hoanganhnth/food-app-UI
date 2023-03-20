package com.example.foodapp;

public class CatogoryDomain {
    private String title;
    private String pic;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public CatogoryDomain(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }
}
