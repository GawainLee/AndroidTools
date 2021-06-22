package com.petpetfairy.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

public class PetDetail implements Parcelable {
    private int id;
    private String petName;
    private String petBreed;
    private String petIdByAgency;
    private String petSex;
    private Date petBirthday;
    private int petAge = 0;
    private String petCenter;
    private String petIntake;
    private String petMicrochip;
    private String petNote;
    private String petDescription;
    private Date createDate;
    private String petDetailLink;
    private String agencyName;
    private String agencyLink;
    private int petDetailLike;
    private List<PetDetailImage> petDetailImageList;

    public PetDetail() {
    }

    public PetDetail(int id, String petName, String petBreed, String petIdByAgency, String petSex, Date petBirthday, int petAge, String petCenter, String petIntake, String petMicrochip, String petNote, String petDescription, Date createDate, String petDetailLink, String agencyName, String agencyLink, int petDetailLike, List<PetDetailImage> petDetailImageList) {
        this.id = id;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petIdByAgency = petIdByAgency;
        this.petSex = petSex;
        this.petBirthday = petBirthday;
        this.petAge = petAge;
        this.petCenter = petCenter;
        this.petIntake = petIntake;
        this.petMicrochip = petMicrochip;
        this.petNote = petNote;
        this.petDescription = petDescription;
        this.createDate = createDate;
        this.petDetailLink = petDetailLink;
        this.agencyName = agencyName;
        this.agencyLink = agencyLink;
        this.petDetailLike = petDetailLike;
        this.petDetailImageList = petDetailImageList;
    }

    protected PetDetail(Parcel in) {
        id = in.readInt();
        petName = in.readString();
        petBreed = in.readString();
        petIdByAgency = in.readString();
        petSex = in.readString();
        petAge = in.readInt();
        petCenter = in.readString();
        petIntake = in.readString();
        petMicrochip = in.readString();
        petNote = in.readString();
        petDescription = in.readString();
        petDetailLink = in.readString();
        agencyName = in.readString();
        agencyLink = in.readString();
        petDetailLike = in.readInt();
    }

    public static final Creator<PetDetail> CREATOR = new Creator<PetDetail>() {
        @Override
        public PetDetail createFromParcel(Parcel in) {
            return new PetDetail(in);
        }

        @Override
        public PetDetail[] newArray(int size) {
            return new PetDetail[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetIdByAgency() {
        return petIdByAgency;
    }

    public void setPetIdByAgency(String petIdByAgency) {
        this.petIdByAgency = petIdByAgency;
    }

    public String getPetSex() {
        return petSex;
    }

    public void setPetSex(String petSex) {
        this.petSex = petSex;
    }

    public Date getPetBirthday() {
        return petBirthday;
    }

    public void setPetBirthday(Date petBirthday) {
        this.petBirthday = petBirthday;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetCenter() {
        return petCenter;
    }

    public void setPetCenter(String petCenter) {
        this.petCenter = petCenter;
    }

    public String getPetIntake() {
        return petIntake;
    }

    public void setPetIntake(String petIntake) {
        this.petIntake = petIntake;
    }

    public String getPetMicrochip() {
        return petMicrochip;
    }

    public void setPetMicrochip(String petMicrochip) {
        this.petMicrochip = petMicrochip;
    }

    public String getPetNote() {
        return petNote;
    }

    public void setPetNote(String petNote) {
        this.petNote = petNote;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPetDetailLink() {
        return petDetailLink;
    }

    public void setPetDetailLink(String petDetailLink) {
        this.petDetailLink = petDetailLink;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyLink() {
        return agencyLink;
    }

    public void setAgencyLink(String agencyLink) {
        this.agencyLink = agencyLink;
    }

    public int getPetDetailLike() {
        return petDetailLike;
    }

    public void setPetDetailLike(int petDetailLike) {
        this.petDetailLike = petDetailLike;
    }

    public List<PetDetailImage> getPetDetailImageList() {
        return petDetailImageList;
    }

    public void setPetDetailImageList(List<PetDetailImage> petDetailImageList) {
        this.petDetailImageList = petDetailImageList;
    }

    @Override
    public String toString() {
        return "PetDetail{" +
                "id=" + id +
                ", petName='" + petName + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", petIdByAgency='" + petIdByAgency + '\'' +
                ", petSex='" + petSex + '\'' +
                ", petBirthday=" + petBirthday +
                ", petAge=" + petAge +
                ", petCenter='" + petCenter + '\'' +
                ", petIntake='" + petIntake + '\'' +
                ", petMicrochip='" + petMicrochip + '\'' +
                ", petNote='" + petNote + '\'' +
                ", petDescription='" + petDescription + '\'' +
                ", createDate=" + createDate +
                ", petDetailLink='" + petDetailLink + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", agencyLink='" + agencyLink + '\'' +
                ", petDetailLike=" + petDetailLike +
                ", petDetailImageList=" + petDetailImageList +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(petName);
        parcel.writeString(petBreed);
        parcel.writeString(petIdByAgency);
        parcel.writeString(petSex);
        parcel.writeInt(petAge);
        parcel.writeString(petCenter);
        parcel.writeString(petIntake);
        parcel.writeString(petMicrochip);
        parcel.writeString(petNote);
        parcel.writeString(petDescription);
        parcel.writeString(petDetailLink);
        parcel.writeString(agencyName);
        parcel.writeString(agencyLink);
        parcel.writeInt(petDetailLike);
    }
}
