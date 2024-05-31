package com.example.fragile_jalihara;

import android.app.Application;
import android.media.Image;
import android.widget.ImageView;

import java.util.Date;

public class GlobalClass extends Application {
    private String username;
    private String password;

    private String category;

    private String showTitle;

    private String showPrice;

    private String showDate;

    private String showLocation;

    private ImageView showImage;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public  String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public  String getShowTitle(){
        return showTitle;
    }
    public void setShowTitle(String showTitle){
        this.showTitle = showTitle;
    }

    public  String getShowPrice(){
        return showPrice;
    }
    public void setShowPrice(String showPrice){
        this.showPrice = showPrice;
    }

    public  String getShowDate(){
        return showDate;
    }
    public void setShowDate(String showDate){
        this.showDate = showDate;
    }

    public  String getShowLocation(){
        return showLocation;
    }
    public void setShowLocation(String showLocation){
        this.showPrice = showPrice;
    }

    public  ImageView getShowImage(){
        return showImage;
    }
    public void setShowImage(ImageView showImage){
        this.showImage = showImage;
    }


}
