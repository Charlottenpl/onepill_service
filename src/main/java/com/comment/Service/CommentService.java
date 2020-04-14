package com.comment.Service;

import com.comment.Dao.CommentRepository;
import com.entity.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

    @Resource
    CommentRepository commentRepository;

    //根据article查询
    public List<Comment> findByArticleId(int id){
        return this.findByArticleId(id);
    }

    //添加评论
    public void add(Comment comment){
        this.commentRepository.save(comment);
    }
}
