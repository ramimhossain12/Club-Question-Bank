package com.example.programmingquestionbank.Image;

import com.google.firebase.database.Exclude;

public class ImageUpload {

    private  String  imageName;
    private  String   imageUrl;
    private  String  key;

    public ImageUpload() {
    }

    public ImageUpload(String imageName, String imageUrl) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String key) {
        this.key = key;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
