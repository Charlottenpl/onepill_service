package com.Cart.controller;


import com.entity.Cart;
import com.google.gson.Gson;
import com.Cart.service.CartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list()
    {
        List<Cart> cartList = this.cartService.findAll();
        String result = gson.toJson(cartList);
        return result;
    }

    //根据UserId查询购物车信息
    @RequestMapping(value = "/findByUserId",method = RequestMethod.GET)
    public String findByUserId(@RequestParam("userId")int userId){
        List<Cart> cartList = this.cartService.findByUserId(userId);
        String result = gson.toJson(cartList);
        return result;
    }

    //增加购物车
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@RequestParam("json")String json){
        try{
            Cart cart = gson.fromJson(json,Cart.class);
            this.cartService.add(cart);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }
    //根据ID删除购物车
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id")int id){
        try{
            this.cartService.delete(id);
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //更改购物车
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("json")String json){
        try{
            this.cartService.add(gson.fromJson(json,Cart.class));
            return "yes";
        }catch (Exception e){
            return "no";
        }
    }

    //
}
/*
try{
        return "yes";
        }catch (Exception e){
        return "no";
        }
        */