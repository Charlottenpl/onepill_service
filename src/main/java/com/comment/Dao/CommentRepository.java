package com.comment.Dao;

import com.entity.Article;
import com.entity.Cart;
import com.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //根据articleId查询
    public List<Comment> findByArticleId(int articleId);
}
