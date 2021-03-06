package com.entity;

import com.Doctor.service.DoctorService;
import com.User.service.UserService;
import com.comment.Service.GoodService;

public class ToComment {
    private int id;
    private int articleId;
    private int userId;
    private int userType;
    private String name;
    private String headImg;
    private String ccomment;
    private int goodNum;
    private boolean isGood;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCcomment() {
        return ccomment;
    }

    public void setCcomment(String ccomment) {
        this.ccomment = ccomment;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
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

    public boolean isGood() {
        return isGood;
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    @Override
    public String toString() {
        return "ToComment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userId=" + userId +
                ", userType=" + userType +
                ", name='" + name + '\'' +
                ", headImg='" + headImg + '\'' +
                ", ccomment='" + ccomment + '\'' +
                ", goodNum=" + goodNum +
                ", isGood=" + isGood +
                '}';
    }

    public static ToComment fromCommentTo(Comment c, DoctorService doctorService, UserService userService, GoodService goodService,int userId,int userType){
        ToComment toComment = new ToComment();
        Doctor doctor = new Doctor();
        User user = new User();
        toComment.setId(c.getId());
        toComment.setArticleId(c.getArticleId());
        toComment.setUserId(c.getUserId());
        toComment.setUserType(c.getUserType());
        toComment.setCcomment(c.getCcomment());
        toComment.setGoodNum(c.getGoodNum());

        if (c.getUserType() == 1){
            doctor = doctorService.findById(c.getUserId());
            doctor.toString();
            toComment.setName(doctor.getName());
            toComment.setHeadImg(doctor.getHeadImg());
        }else {
            user = userService.findById(c.getUserId());
            user.toString();
            toComment.setName(user.getNickName());
            toComment.setHeadImg(user.getHeadImg());
        }
        if (userType == 2){
            toComment.setGood(goodService.isGood(userId, c.getId()));
        }else {
            toComment.setGood(false);
        }


        return toComment;
    }

    public static Comment fromToCommentTo(ToComment toComment){
        Comment comment = new Comment();
        comment.setId(toComment.getId());
        comment.setUserId(toComment.getUserId());
        comment.setUserType(toComment.getUserType());
        comment.setArticleId(toComment.getArticleId());
        comment.setGoodNum(toComment.getGoodNum());
        comment.setCcomment(toComment.getCcomment());
        return comment;
    }
}
