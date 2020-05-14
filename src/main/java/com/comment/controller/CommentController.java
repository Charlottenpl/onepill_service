package com.comment.controller;

import com.Doctor.service.DoctorService;
import com.User.service.UserService;
import com.comment.Service.CommentService;
import com.comment.Service.GoodService;
import com.entity.Cart;
import com.entity.Comment;
import com.entity.Doctor;
import com.entity.ToComment;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comment")
@Api("评论服务器")
public class CommentController {

    @Resource
    CommentService commentService;
    @Resource
    DoctorService doctorService;
    @Resource
    UserService userService;
    @Resource
    GoodService goodService;
    Gson gson = new Gson();

    //获取文章的所有评论
    @RequestMapping(value = "/getComment", method = RequestMethod.GET)
    @ApiOperation("获取文章的所有评论")
    public String findByArticleId(@RequestParam(name = "articleId") int articleId,@RequestParam(name = "userId")int userId,@RequestParam(name = "userType")int userType) {
        List<Comment> commentList = this.commentService.findByArticleId(articleId);
        List<ToComment> toCommentList = new ArrayList<>();
        for (Comment c : commentList
        ) {
//            toComment.setId(c.getId());
//            toComment.setArticleId(c.getArticleId());
//            toComment.setUserId(c.getUserId());
//            toComment.setUserType(c.getUserType());
//            toComment.setCcomment(c.getCcomment());
//            toComment.setGoodNum(c.getGoodNum());
//
//            doctor = doctorService.findById(c.getUserId());
//            toComment.setName(doctor.getName());
//            toComment.setHeadImg(doctor.getHeadImg());
            toCommentList.add(ToComment.fromCommentTo(c, doctorService,userService,goodService,userId,userType));
        }
        return gson.toJson(toCommentList);
    }

    //根据UserId查询
    @PostMapping("/getCommentByUserId")
    public String findByUserIdAndUserType(@RequestParam(name = "userId") int userId, @RequestParam(name = "userType") int userType) {
        List<Comment> commentList = this.commentService.findByUserIdAndUserType(userId, userType);
        List<ToComment> toCommentList = new ArrayList<>();
        for (Comment c : commentList
        ) {
            toCommentList.add(ToComment.fromCommentTo(c,doctorService,userService,goodService,userId,userType));
        }
        return gson.toJson(toCommentList);
    }

    //添加评论
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加评论")
    public String add(@RequestParam(name = "json") String json) {
        System.out.println("插入评论"+json);
        try {
            ToComment comment = gson.fromJson(json, ToComment.class);
            this.commentService.add(ToComment.fromToCommentTo(comment));
            return "true";
        } catch (Exception e) {
            return "false";
        }
    }

    //更新评论
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody String json) {
        try {
            ToComment comment = gson.fromJson(json, ToComment.class);
            this.commentService.add(ToComment.fromToCommentTo(comment));
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}
