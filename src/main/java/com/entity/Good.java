package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "good")
public class Good {
    private int Id;
    private int userId;
    private int commentId;

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "good{" +
                "Id=" + Id +
                ", userId=" + userId +
                ", commentId=" + commentId +
                '}';
    }
}
