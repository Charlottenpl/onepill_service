package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_medicine" )
public class Medicine {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String generalName;
    private String medicine;
    private int price;
    private String overview;
    private String function;
    private String introdutions;
    private String sideEffect;
    private String forbiddance;
    private int doctorId;
    private String img1;
    private String img2;
    private String img3;
    private String standard;
    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGeneralName() {
        return generalName;
    }

    public void setGeneralName(String generalName) {
        this.generalName = generalName;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getIntrodutions() {
        return introdutions;
    }

    public void setIntrodutions(String introdutions) {
        this.introdutions = introdutions;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getForbiddance() {
        return forbiddance;
    }

    public void setForbiddance(String forbiddance) {
        this.forbiddance = forbiddance;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", generalName='" + generalName + '\'' +
                ", medicine='" + medicine + '\'' +
                ", price='" + price + '\'' +
                ", overview='" + overview + '\'' +
                ", function='" + function + '\'' +
                ", introdutions='" + introdutions + '\'' +
                ", sideEffect='" + sideEffect + '\'' +
                ", forbiddance='" + forbiddance + '\'' +
                ", doctorId=" + doctorId +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", standard='" + standard + '\'' +
                ", stock=" + stock +
                '}';
    }
}
