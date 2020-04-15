package com.comment.controller;

import com.comment.Service.CommentService;
import com.entity.Cart;
import com.entity.Comment;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
@Api("评论服务器")
public class CommentController {

    @Resource
    CommentService commentService;
    Gson gson = new Gson();

    //获取文章的所有评论
    @RequestMapping(value = "/getComment",method = RequestMethod.GET)
    @ApiOperation("获取文章的所有评论")
    public String findByArticleId(@RequestParam(name = "articleId")int articleId){
        return gson.toJson(this.commentService.findByArticleId(articleId));
    }

    //添加评论
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation("添加评论")
    public String add(@RequestParam(name = "json")String json){
        try{
            Comment comment = gson.fromJson(json, Comment.class);
            this.commentService.add(comment);
            return "true";
        }catch (Exception e){
            return "false";
        }
    }
}
