package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    private int id;
    private String name;
    private String phone;
    private String address;
    private String password;
    private String PID;
    private String hospital;
    private String tag;
    private String headImg;
    private String licence1;
    private String licence2;
    private String resume;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getLicence1() {
        return licence1;
    }

    public void setLicence1(String licence1) {
        this.licence1 = licence1;
    }

    public String getLicence2() {
        return licence2;
    }

    public void setLicence2(String licence2) {
        this.licence2 = licence2;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", PID='" + PID + '\'' +
                ", hospital='" + hospital + '\'' +
                ", tag='" + tag + '\'' +
                ", headImg='" + headImg + '\'' +
                ", licence1='" + licence1 + '\'' +
                ", licence2='" + licence2 + '\'' +
                ", resume='" + resume + '\'' +
                '}';
    }
}
