package com.comment.Service;

import com.comment.Dao.CommentRepository;
import com.comment.Dao.GoodRepository;
import com.entity.Comment;
import com.entity.Good;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodService {

    @Resource
    GoodRepository goodRepository;
    @Resource
    CommentRepository commentRepository;

    //查询是否已经点赞
    public boolean isGood(int userId, int commentId) {
        Good g = this.goodRepository.findByUserIdAndCommentId(userId,commentId);
        if (g != null) {
            return true;
        }else {
            return false;
        }
    }

    //点赞
    public void add(Good good) {
        this.goodRepository.save(good);
    }

    //取消点赞
    public void del(int userId,int commentId) {
        this.goodRepository.deleteByUserIdAndCommentId(Integer.valueOf(userId), Integer.valueOf(commentId));
    }

    //根据userId查询点赞的评论
    public List<Comment> findCommentByUserId(int userId) {
        List<Good> goods = this.goodRepository.findByUserId(userId);
        List<Comment> commentList = new ArrayList<>();
        Comment comment = new Comment();
        for (Good g : goods
        ) {
            comment = this.commentRepository.findById(g.getCommentId());
            commentList.add(comment);
        }
        return commentList;

    }
}
