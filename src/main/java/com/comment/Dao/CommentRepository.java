package com.comment.Dao;

import com.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //根据articleId查询
    public List<Comment> findByArticleId(int articleId);

//    //更新评论的点赞数和踩数
//    @Modifying
//    @Query(value = "update Comment c set ")
//    public void update();
}
