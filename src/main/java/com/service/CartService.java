package com.service;

import com.Dao.CartRepository;
import com.entity.Cart;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartService {

    @Resource
    CartRepository cartRepository;

    //查询全部
    public List<Cart> findAll(){
        return this.cartRepository.findAll();
    }
}
