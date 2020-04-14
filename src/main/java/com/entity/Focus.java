package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_focus")
public class Focus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//Id自增
    private int userId;//用户ID
    private int userType;//用户类型（1：医生2：用户）
    private int type;//关注类型（1：医生2：药品）
    private int typeId;//关注对象Id

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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "Focus{" +
                "id=" + id +
                ", userId=" + userId +
                ", userType=" + userType +
                ", type=" + type +
                ", typeId=" + typeId +
                '}';
    }
}
