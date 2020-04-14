package com.comment.controller;

import com.comment.Service.CommentService;
import com.entity.Cart;
import com.entity.Comment;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;
    Gson gson = new Gson();

    @RequestMapping(value = "/getComment",method = RequestMethod.GET)
    public String findByArticleId(@RequestParam("articleId")int articleId){
        return gson.toJson(this.commentService.findByArticleId(articleId));
    }

    //添加评论
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json")String json){
        try{
            Comment comment = gson.fromJson(json, Comment.class);
            this.commentService.add(comment);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
}
