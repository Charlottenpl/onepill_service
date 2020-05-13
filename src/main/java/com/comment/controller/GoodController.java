package com.comment.controller;

import com.comment.Service.CommentService;
import com.comment.Service.GoodService;
import com.entity.Comment;
import com.entity.Good;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    GoodService goodService;
    @Resource
    CommentService commentService;

    //查询是否已经点赞
    @GetMapping("/isGood")
    public String isGood(@RequestParam(name = "userId") int userId, @RequestParam(name = "commentId") int commentId){
        if (this.goodService.isGood(userId,commentId)) {
            return "yes";
        } else {
            return "no";
        }
    }
    //点赞
    @GetMapping("/add")
    public String add(@RequestParam(name = "userId") int userId, @RequestParam(name = "commentId") int commentId){
        try{
            Good good = new Good();
            good.setCommentId(commentId);
            good.setUserId(userId);
            this.goodService.add(good);
            Comment comment = this.commentService.findById(commentId);
            int goodNum = comment.getGoodNum()+1;
            comment.setGoodNum(goodNum);
            this.commentService.update(comment);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
    //取消点赞
    @GetMapping("/del")
    public String del(@RequestParam(name = "userId") int userId, @RequestParam(name = "commentId") int commentId){
        try{
            this.goodService.del(userId, commentId);
            Comment comment = this.commentService.findById(commentId);
            int goodNum = comment.getGoodNum()-1;
            comment.setGoodNum(goodNum);
            this.commentService.update(comment);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //根据userId查询点赞的评论
    @PostMapping("/findByUserId")
    public String findCommentByUserId(@RequestParam("userId")int userId){
        Gson gsonl = new Gson();
        return gsonl.toJson(this.goodService.findCommentByUserId(userId));
    }

}
