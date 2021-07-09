package com.petpetfairy.model;

public class PetDetailImage {
    private int idPetDetailImage;
    private String petDetailPetLink;
    private String petDetailImageLink;
    private int petDetailImageWeight;
    private int petDetailImageHeight;

    public PetDetailImage(int idPetDetailImage, String petDetailPetLink, String petDetailImageLink, int petDetailImageWeight, int petDetailImageHeight) {
        this.idPetDetailImage = idPetDetailImage;
        this.petDetailPetLink = petDetailPetLink;
        this.petDetailImageLink = petDetailImageLink;
        this.petDetailImageWeight = petDetailImageWeight;
        this.petDetailImageHeight = petDetailImageHeight;
    }

    public int getIdPetDetailImage() {
        return idPetDetailImage;
    }

    public void setIdPetDetailImage(int idPetDetailImage) {
        this.idPetDetailImage = idPetDetailImage;
    }

    public String getPetDetailPetLink() {
        return petDetailPetLink;
    }

    public void setPetDetailPetLink(String petDetailPetLink) {
        this.petDetailPetLink = petDetailPetLink;
    }

    public String getPetDetailImageLink() {
        return petDetailImageLink;
    }

    public void setPetDetailImageLink(String petDetailImageLink) {
        this.petDetailImageLink = petDetailImageLink;
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

    @Override
    public String toString() {
        return "PetDetailImage{" +
                "idPetDetailImage=" + idPetDetailImage +
                ", petDetailPetLink='" + petDetailPetLink + '\'' +
                ", petDetailImageLink='" + petDetailImageLink + '\'' +
                ", petDetailImageWeight=" + petDetailImageWeight +
                ", petDetailImageHeight=" + petDetailImageHeight +
                '}';
    }
}
