package com.Article.controller;

import com.Article.service.ArticleService;
import com.entity.Address;
import com.entity.Article;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    ArticleService articleService;
    Gson gson = new Gson();

    //查询全部
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(){
        return gson.toJson(this.articleService.findAll());
    }

    //根据ID查询
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public String findById(@RequestParam("id")int id){
        return gson.toJson(this.findById(id));
    }

    //根据ID删除
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") int id){
        try{
            this.articleService.deleteById(id);
            return "yes";
        }catch(Exception e){
            return "no";
        }
    }

    //添加Article
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String delete(@RequestParam("json") String json){
        try{
            Article article = gson.fromJson(json,Article.class);
            this.articleService.add(article);
            return "yes";
        }catch(Exception e){
            return "no";
        }
    }

}
