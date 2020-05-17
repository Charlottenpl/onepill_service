package com.entity;

public class MyOrder {
    private int id;
    private int userId;
    private int medicineId;
    private int count;//数量
    private String img;
    private int price;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", medicineId=" + medicineId +
                ", count=" + count +
                ", img='" + img + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
