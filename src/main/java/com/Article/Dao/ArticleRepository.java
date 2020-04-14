package com.Article.Dao;

import com.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Integer> {

    //根据ID查询
    public Article findById(int id);
}
