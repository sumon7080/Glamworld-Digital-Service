package com.example.glamworlddigitalservice.serviceList;

public class Upload_Service {


    private String imgName;
    private String imgUrl;
    private String imgPrice;
    private String imgDetails;

    public Upload_Service() {
    }

    public Upload_Service(String imgName, String imgUrl, String imgPrice, String imgDetails) {
        this.imgName = imgName;
        this.imgUrl = imgUrl;
        this.imgPrice = imgPrice;
        this.imgDetails = imgDetails;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgPrice() {
        return imgPrice;
    }

    public void setImgPrice(String imgPrice) {
        this.imgPrice = imgPrice;
    }

    public String getImgDetails() {
        return imgDetails;
    }

    public void setImgDetails(String imgDetails) {
        this.imgDetails = imgDetails;
    }
}
