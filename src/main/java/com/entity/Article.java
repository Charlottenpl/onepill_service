package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_article")
public class Article {
    private int id;
    private String title;
    private String headImg;
    private String content;
    private String tag;
    private String writerName;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", headImg='" + headImg + '\'' +
                ", content='" + content + '\'' +
                ", tag='" + tag + '\'' +
                ", writerName='" + writerName + '\'' +
                '}';
    }
}
