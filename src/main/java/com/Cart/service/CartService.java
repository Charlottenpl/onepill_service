package com.Cart.service;

import com.Cart.Dao.CartRepository;
import com.entity.Cart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartService {

    @Resource
    CartRepository cartRepository;

    //查询全部（没啥用）
    public List<Cart> findAll(){
        return this.cartRepository.findAll();
    }

    //根据UserId查询
    public List<Cart> findByUserId(int userId){
        return this.findByUserId(userId);
    }

    //添加
    public void add(Cart cart){
        this.cartRepository.save(cart);
    }

    //删除
    public void delete(int id){
        this.cartRepository.deleteCartById(id);
    }

}
