package com.petpetfairy.model;

public class PetListItem {
    public static  final int TYPE_IMAGE_V=1;
    public static  final int TYPE_IMAGE_H=2;

    private int petListItemId;
    private String petListItemName;
    private String petListItemDetailLink;
    private int petListItemLike;
    private int imageType;

    private int petDetailImageWeight;
    private int petDetailImageHeight;


    public PetListItem(int petListItemId, String petListItemName, String petListItemDetailLink, int petListItemLike, int petDetailImageWeight, int petDetailImageHeight) {
        this.petListItemId = petListItemId;
        this.petListItemName = petListItemName;
        this.petListItemDetailLink = petListItemDetailLink;
        this.petListItemLike = petListItemLike;
        this.petDetailImageWeight = petDetailImageWeight;
        this.petDetailImageHeight = petDetailImageHeight;
        if (petDetailImageWeight >= petDetailImageHeight){
            this.imageType = TYPE_IMAGE_V;
        }else{
            this.imageType = TYPE_IMAGE_H;
        }

    }

    @Override
    public String toString() {
        return "PetListItem{" +
                "petListItemId=" + petListItemId +
                ", petListItemName='" + petListItemName + '\'' +
                ", petListItemDetailLink='" + petListItemDetailLink + '\'' +
                ", petListItemLike=" + petListItemLike +
                ", imageType=" + imageType +
                ", petDetailImageWeight=" + petDetailImageWeight +
                ", petDetailImageHeight=" + petDetailImageHeight +
                '}';
    }

    public int getPetDetailImageWeight() {
        return petDetailImageWeight;
    }

    public void setPetDetailImageWeight(int petDetailImageWeight) {
        this.petDetailImageWeight = petDetailImageWeight;
    }

    public int getPetDetailImageHeight() {
        return petDetailImageHeight;
    }

    public void setPetDetailImageHeight(int petDetailImageHeight) {
        this.petDetailImageHeight = petDetailImageHeight;
    }

    public int getImageType() {
        return imageType;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    public int getPetListItemId() {
        return petListItemId;
    }

    public void setPetListItemId(int petListItemId) {
        this.petListItemId = petListItemId;
    }

    public String getPetListItemName() {
        return petListItemName;
    }

    public void setPetListItemName(String petListItemName) {
        this.petListItemName = petListItemName;
    }

    public String getPetListItemDetailLink() {
        return petListItemDetailLink;
    }

    public void setPetListItemDetailLink(String petListItemDetailLink) {
        this.petListItemDetailLink = petListItemDetailLink;
    }

    public int getPetListItemLike() {
        return petListItemLike;
    }

    public void setPetListItemLike(int petListItemLike) {
        this.petListItemLike = petListItemLike;
    }
}
