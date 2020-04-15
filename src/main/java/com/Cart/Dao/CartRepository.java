package com.Cart.Dao;

import com.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    //根据UserId查询加入的购物车商品
    public List<Cart> findByUserId(int userId);

    //根据ID删除
    public int deleteCartById(int id);
}