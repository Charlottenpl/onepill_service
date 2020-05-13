package com.Article.controller;

import com.Article.service.ArticleService;
import com.Doctor.service.DoctorService;
import com.entity.Address;
import com.entity.Article;
import com.entity.Doctor;
import com.entity.ToArticle;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/article")
@Api("文章服务器")
public class ArticleController {

    @Resource
    ArticleService articleService;
    @Resource
    DoctorService doctorService;
    Gson gson = new Gson();

    //查询全部
    @ApiOperation(value = "查询全部文章")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        List<Article> articleList = new ArrayList<>();
        List<ToArticle> toArticleList = new ArrayList<>();
        articleList = this.articleService.findAll();
        for (Article a : articleList
        ) {
            toArticleList.add(ToArticle.formArticleTo(a,doctorService));
        }
        return gson.toJson(toArticleList);
    }

    //根据ID查询
    @ApiOperation(value = "根据Id查询文章")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public String findById(@RequestParam("id") int id) {
        return gson.toJson(ToArticle.formArticleTo(this.articleService.findById(id),doctorService));
    }

    //根据ID删除
    @ApiOperation(value = "根据ID删除文章")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id) {
        try {
            this.articleService.deleteById(id);
            return "yes";
        } catch (Exception e) {
            return "no";
        }
    }

    //添加Article
    @ApiOperation(value = "向数据库添加文章")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String delete(@RequestParam("json") String json,@RequestParam("userId") int userId) {
        try {
            ToArticle article = gson.fromJson(json, ToArticle.class);
            this.articleService.add(ToArticle.fromToArticleTo(article,userId));
            return "yes";
        } catch (Exception e) {
            return "no";
        }
    }

}


//@ApiOperation(value = "",notes = "")