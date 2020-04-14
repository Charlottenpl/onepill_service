package com.Article.service;

import com.Article.Dao.ArticleRepository;
import com.entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    ArticleRepository articleRepository;

    //查询所有
    public List<Article> findAll(){
        return this.articleRepository.findAll();
    }

    //根据Id查询
    public Article findById(int id){
        return this.articleRepository.findById(id);
    }

    //添加Article
    public void add(Article article){
        this.articleRepository.save(article);
    }

    //删除
    public void deleteById(int id){
        this.articleRepository.deleteById(id);
    }


}
