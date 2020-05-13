package com.entity;

import com.Doctor.service.DoctorService;

import javax.print.Doc;

public class ToArticle {

    private int id;
    private String headImg;
    private String writerName;
    private String content;
    private String tag;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ToArticle{" +
                "id=" + id +
                ", headImg='" + headImg + '\'' +
                ", writerName='" + writerName + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static ToArticle formArticleTo(Article a, DoctorService doctorService){
        Doctor doctor = new Doctor();
        ToArticle toArticle = new ToArticle();
        toArticle.setId(a.getId());
        toArticle.setContent(a.getContent());
        toArticle.setTag(a.getTag());
        toArticle.setTitle(a.getTitle());

        doctor = doctorService.findById(a.getUserId());
        toArticle.setWriterName(doctor.getName());
        toArticle.setHeadImg(doctor.getHeadImg());
        return toArticle;
    }

    public static Article fromToArticleTo(ToArticle toArticle,int userId){
        Article article = new Article();
        article.setId(toArticle.getId());
        article.setTitle(toArticle.getTitle());
        article.setContent(toArticle.getContent());
        article.setTag(toArticle.getTag());
        article.setUserId(userId);
        return article;
    }

}
