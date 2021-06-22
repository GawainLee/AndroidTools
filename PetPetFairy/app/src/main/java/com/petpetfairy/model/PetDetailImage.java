package com.petpetfairy.model;

public class PetDetailImage {
    private int idPetDetailImage;
    private String petDetailPetLink;
    private String petDetailImageLink;

    public PetDetailImage(int idPetDetailImage, String petDetailPetLink, String petDetailImageLink) {
        this.idPetDetailImage = idPetDetailImage;
        this.petDetailPetLink = petDetailPetLink;
        this.petDetailImageLink = petDetailImageLink;
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

    @Override
    public String toString() {
        return "PetDetailImage{" +
                "idPetDetailImage=" + idPetDetailImage +
                ", petDetailPetLink='" + petDetailPetLink + '\'' +
                ", petDetailImageLink='" + petDetailImageLink + '\'' +
                '}';
    }
}
