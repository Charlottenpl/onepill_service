package com.comment.Dao;

import com.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    //根据articleId查询
    public List<Comment> findByArticleId(int articleId);
    //根据userId查询
    public List<Comment> findByUserIdAndUserType(int userId,int userType);
    //根据Id查询
    public Comment findById(int id);


//    //更新评论的点赞数和踩数
//    @Modifying
//    @Query(value = "update Comment c set ")
//    public void update();
}
