package com.example.News;

public class relatedNews {
    private int id,img;
    private String headL;



    private String fullNews;


    public relatedNews(int id, int img,  String headL, String fullNews) {
        this.id = id;
        this.img = img;
        this.headL = headL;
        this.fullNews = fullNews;
    }
    public int getId() {
        return id;
    }

    public int getImg() {
        return img;
    }

    public String getHeadL() {
        return headL;
    }

    public String getFullNews() {
        return fullNews;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setHeadL(String headL) {
        this.headL = headL;
    }

    public void setFullNews(String fullNews) {
        this.fullNews = fullNews;
    }


}
