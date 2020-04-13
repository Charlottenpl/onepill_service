package com.controller;


import com.entity.Cart;
import com.google.gson.Gson;
import com.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Resource
    CartService cartService;
    Gson gson = new Gson();

    //获取所有购物车信息
    @RequestMapping(value = "/list")
    public String list()
    {
        List<Cart> cartList = this.cartService.findAll();
        String result = gson.toJson(cartList);
        return result;
    }
}
