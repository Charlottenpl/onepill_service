package com.comment.Dao;


import com.entity.Good;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodRepository extends JpaRepository<Good,Integer> {

    //查询是否已经点赞
    public boolean findByUserIdAndCommentId(int userId,int commentId);

    //根据UserId查询
    public List<Good> findByUserId(int userId);

    //根据UserId和CommentId删除
    public boolean deleteByUserIdAndCommentId(int userId,int commentId);
}
