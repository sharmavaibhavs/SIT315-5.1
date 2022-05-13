package com.example.News;

public class FragmentRecyclerModel {


    int img;

    String headline;


    public FragmentRecyclerModel(String headline, int img) {
        this.headline = headline;
        this.img = img;
    }



    public String getHeadline() {
        return headline;
    }

    public int getImg() {
        return img;
    }


}
